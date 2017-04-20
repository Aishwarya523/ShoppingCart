package com.niit.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.CustomerDAO;
import com.niit.model.CategoryModel;
import com.niit.model.CustomerModel;


@Controller
public class HomeController {
	@Autowired
	CustomerDAO customerDA;
	@Autowired
	CategoryDAO categorydao;
	@RequestMapping("/")
	public ModelAndView showHomepage()
	{
		System.out.println("show Homepage");
		ModelAndView mv = new ModelAndView("home");
		List<CategoryModel> categoryList=categorydao.retriveCategory(null);
		for(int i=0;i<categoryList.size();i++){
			CategoryModel ct=categoryList.get(i);
			System.out.println(ct.getName());
			
		}
		mv.addObject("msg", "WELCOME TO ");
		mv.addObject("result", categoryList);
		
		return mv;
	}
	@RequestMapping("logincheck")
	public ModelAndView showAdminpage()
	{
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		Collection<? extends GrantedAuthority> auths = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		ModelAndView mv = null;
		for(GrantedAuthority auth:auths){
			if(auth.getAuthority().equals("ROLE_ADMIN")){
				System.out.println("show Adminpage");
				mv = new ModelAndView("home");
				List<CategoryModel> categoryList=categorydao.retriveCategory(null);
				mv.addObject("result", categoryList);
			}
			else{
				mv = new ModelAndView("home");
				List<CategoryModel> categoryList=categorydao.retriveCategory(null);
				mv.addObject("result", categoryList);
				
			}
		}
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView showLoginpage()
	{
		System.out.println("Clicked on Login link");
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("isUserClickedLogin","true" );
		
		return mv;
	}
	@RequestMapping("roleError")
	public ModelAndView showRoleError()
	{
		
		ModelAndView mv = new ModelAndView("roleError");
		
		
		return mv;
	}
	
	@RequestMapping("validate")
	public ModelAndView validateCredentials(CustomerModel customer, @RequestParam("username") String id, @RequestParam("password") String pwd)
	{
		String msg;
		ModelAndView  mv = new ModelAndView("home");
		System.out.println(customer);
		List<CustomerModel> customerList=customerDA.validateLogin(customer);
		if(customerList.size()==0){
			System.out.println("invalid user");
			msg="invalid user";
		}
		else{
			System.out.println("valid user");
			msg="valid user";
		}
		mv=new ModelAndView("/login","result",msg);
		 return mv;
		}
	
	
	
	
	
	    
}
