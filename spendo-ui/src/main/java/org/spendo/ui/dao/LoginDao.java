package org.spendo.ui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.spendo.commons.vo.json.ExpCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	private JdbcTemplate jdbcTemplate;
	
	private static Logger logger = Logger.getLogger(LoginDao.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean checkLogin(String username, String password) {
		boolean isLoginPassed = false;
		String loginQuery = "select count(*) as count from sp_users where user_login=? and user_pass=?";
		logger.info("LoginQuery:::" + loginQuery);
		PreparedStatementCreator preparedStatementCreator = null;
//		LoginRowCallbackHandler loginRowCallbackHandler = new LoginRowCallbackHandler();
//		jdbcTemplate.query(loginQuery, loginRowCallbackHandler);
		isLoginPassed = jdbcTemplate.execute(loginQuery, new PreparedStatementCallbackImpl(username, password));
//		isLoginPassed = loginRowCallbackHandler.isLoginPassed;
		return isLoginPassed;
	}
	
	@Cacheable(value="categoryCache", key="'allCategories'")
	public List<ExpCategory> getAllCategories() {
		List<ExpCategory> allCategoryMasts = new ArrayList<ExpCategory>();
		String categoryQuery = "select exp_category_id, category_name,category_description from  sp_expenditure_category_mast";
		logger.info("Category Query:::"+categoryQuery);
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(categoryQuery);
		for (Map<String, Object> map : resultList) {
			ExpCategory cm = new ExpCategory();
			cm.setId((Integer) map.get("exp_category_id"));
			cm.setName((String) map.get("category_name"));
			cm.setDescription((String)map.get("category_description"));
			allCategoryMasts.add(cm);
		}
		return allCategoryMasts;
	}
	
	class PreparedStatementCallbackImpl implements PreparedStatementCallback<Boolean> {
		
		String userName = null;
		
		String passWord = null;
		
		public PreparedStatementCallbackImpl(String userName, String passWord) {
			this.userName = userName;
			this.passWord = passWord;
		}

		@Override
		public Boolean doInPreparedStatement(PreparedStatement arg0)
				throws SQLException, DataAccessException {
			arg0.setString(1, userName);
			arg0.setString(2, passWord);
			arg0.execute();
			ResultSet rs = arg0.getResultSet();
			int count = -1;
			while (rs.next()) {
				count = rs.getInt("count");
			}
			logger.info("login match count:"+count);
			return count > 0 ? true : false;
		}
		
	}
	
	class PreparedStatementCreatorImpl implements PreparedStatementCreator {

		@Override
		public PreparedStatement createPreparedStatement(Connection arg0)
				throws SQLException {
			String loginQuery = "select count(*) as count from sp_users where user_login=? and user_pass=?";

			PreparedStatement ps = arg0.prepareStatement(loginQuery);
			return ps;
		}
		
	}
	
	class LoginRowCallbackHandler implements RowCallbackHandler {

		private boolean isLoginPassed = false;

		public boolean isLoginPassed() {
			return isLoginPassed;
		}

		public void setLoginPassed(boolean isLoginPassed) {
			this.isLoginPassed = isLoginPassed;
		}

		public void processRow(ResultSet arg0) throws SQLException {
			if (arg0.getInt("count") > 0) {
				isLoginPassed = true;
			}
		}

	}

}
