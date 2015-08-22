package com.mas.em.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("category")
public class CategoryController {

	@RequestMapping(value="/info", method=GET)
	public String getCategoryInfo(Model model) {
		
		return "category/categoryInfo";
	}
}
