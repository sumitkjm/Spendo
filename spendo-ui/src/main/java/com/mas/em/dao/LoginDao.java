package com.mas.em.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.mas.em.common.vo.category.CategoryMast;

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
		String loginQuery = "select count(*) as count from sp_users where username='"
				+ username + "' and password='" + password + "'";
		logger.info("LoginQuery:::" + loginQuery);
		LoginRowCallbackHandler loginRowCallbackHandler = new LoginRowCallbackHandler();
		jdbcTemplate.query(loginQuery, loginRowCallbackHandler);
		isLoginPassed = loginRowCallbackHandler.isLoginPassed;
		return isLoginPassed;
	}
	
	@Cacheable(value="categoryCache", key="'allCategories'")
	public List<CategoryMast> getAllCategories() {
		List<CategoryMast> allCategoryMasts = new ArrayList<CategoryMast>();
		String categoryQuery = "select category_id, category_name from sp_category_mast";
		logger.info("Category Query:::"+categoryQuery);
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(categoryQuery);
		for (Map<String, Object> map : resultList) {
			CategoryMast cm = new CategoryMast();
			cm.setCategoryID((Integer) map.get("category_id"));
			cm.setCategoryName((String) map.get("category_name"));
			allCategoryMasts.add(cm);
		}
		return allCategoryMasts;
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
