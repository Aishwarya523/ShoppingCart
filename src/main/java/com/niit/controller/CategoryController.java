package com.niit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.model.CategoryModel;

import java.util.List;

@Controller
public class CategoryController {
	@Autowired
		CategoryDAO categorydao;
		
		@RequestMapping(value="category",method=RequestMethod.GET)
		public ModelAndView sendcategory(@ModelAttribute("category") CategoryModel category)
		{
			List<CategoryModel> categoryList=categorydao.retriveCategory(category);

			ModelAndView mv=new ModelAndView("/category","result",categoryList);
			
			return mv;
		}
		
		@RequestMapping(value="category", method=RequestMethod.POST)
		
	    public ModelAndView getCategory(CategoryModel category,@RequestParam("operation") String operation	)
		{
			ModelAndView mv=new ModelAndView("/category","category",new CategoryModel());
			if(operation.equalsIgnoreCase("add")){
				categorydao.addCategory(category);
				List<CategoryModel> categoryList=categorydao.retriveCategory(null);

				 mv=new ModelAndView("/category","result",categoryList);
				
			}
			else if(operation.equalsIgnoreCase("retrive")){
				List<CategoryModel> categoryList=categorydao.retriveCategory(category);

				mv=new ModelAndView("/category","result",categoryList);
			}
			else if(operation.equalsIgnoreCase("update")){
				categorydao.updateCategory(category);
			}
			return mv;
		}
			@RequestMapping(value = "deletecategory", method = RequestMethod.GET) 
			public ModelAndView deleteCategory(@RequestParam("productId") String productid) {
				System.out.println("Delete Controller Reached");
				CategoryModel category =new CategoryModel();
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+productid);
				category.setProductid(productid);
				
				
				categorydao.deleteCategory(category);
				List<CategoryModel> categoryList=categorydao.retriveCategory(null);

				ModelAndView mv=new ModelAndView("/category","result",categoryList);
			
				return mv ;		
			
		}


	}


