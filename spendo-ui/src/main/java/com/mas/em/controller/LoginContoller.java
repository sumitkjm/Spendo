package com.mas.em.controller;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mas.em.common.vo.category.CategoryMast;
import com.mas.em.dao.LoginDao;

@Controller
@RequestMapping("login")
public class LoginContoller {
	
	@Autowired
//	@Qualifier("loginDao")
	private LoginDao loginDao;
		
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String doLogin(Model model) {
		
		return "login/login";
	}
	
	@RequestMapping(value="/action", method=RequestMethod.POST)
	public String loginAction(Model model, HttpServletRequest request) {
		System.out.println("inside loginAction...");
		String username = request.getParameter("login");
		String password = request.getParameter("passwd");
		boolean isLoginPassed = loginDao.checkLogin(username, password);
		if(isLoginPassed) {
			List<CategoryMast> categoryMasts = loginDao.getAllCategories();
			model.addAttribute("allCategoryMasts", categoryMasts);
			return "category/categoryinfo";
		} else {
			return "login/loginfailed";
		}
	}

}
