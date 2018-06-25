package com.bs.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.ps.dao.CategoryDao;

@Controller
public class HomeController {
 
	@Autowired
	private CategoryDao categorydo;
	
	
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickHome", true);
		mv.addObject("title","home");
		mv.addObject("categories",categorydo.getCategory());
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAbout", true);
		mv.addObject("categories",categorydo.getCategory());
		mv.addObject("title","about");
		return mv;
	}
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickContact", true);
		mv.addObject("categories",categorydo.getCategory());
		mv.addObject("title","contact");
		return mv;
	}
	
	@RequestMapping("/showByCategory/{id}/All")
	public ModelAndView showProductByCategory(@PathVariable ("id") int id)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickByCategory", true);
		mv.addObject("category",categorydo.getCategoryInt(id));
		mv.addObject("categories",categorydo.getCategory());
		mv.addObject("title",categorydo.getCategoryInt(id).getName());
		
		return mv;
	}
	
	@RequestMapping("/all/product")
	public ModelAndView showAllProduct()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userAllProduct", true);
		mv.addObject("title","All Product");
		mv.addObject("categories",categorydo.getCategory());
		
		return mv;
	}
}
