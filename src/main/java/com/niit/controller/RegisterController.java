package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CustomerDAO;
import com.niit.model.CategoryModel;
import com.niit.model.CustomerModel;


@Controller
public class RegisterController {
	
	@Autowired
	CustomerDAO customerdao;
	private CustomerDAO customerydao;
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public ModelAndView sendregister(@ModelAttribute("customer") CustomerModel customer)
	{
		ModelAndView mv=new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	 public String getCustomer(CustomerModel customer,@RequestParam("operation") String operation	)
	{
		if(operation.equalsIgnoreCase("add")){
			customerdao.addCustomer(customer);
			
		}
		else if(operation.equalsIgnoreCase("retrive")){
				customerydao = null;
				List<CustomerModel> customerList=customerdao.retriveCustomer(customer);

				ModelAndView mv = new ModelAndView("/customer","result",customerList);
			customerydao.retriveCustomer(customer);
			
		}
		else if(operation.equalsIgnoreCase("update")){
			customerdao.updateCustomer(customer);
		}
		else if(operation.equalsIgnoreCase("delete")){
			customerdao.deleteCustomer(customer);
		}
		
	{
		
		customerdao.addCustomer(customer);
		
	
		return "login";		
		
	}
	}
}


