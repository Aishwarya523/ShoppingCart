package com.niit.controller;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.CategoryModel;
import com.niit.model.ProductModel;
import com.niit.model.SupplierModel;


	@Controller
	public class ProductController {
		@Autowired
			ProductDAO productdao;
		@Autowired
		CategoryDAO categorydao;
		@Autowired
		SupplierDAO supplierdao;
			
			@RequestMapping(value="product",method=RequestMethod.GET)
			public ModelAndView sendproduct(@ModelAttribute("product") ProductModel product)
			{
				List<ProductModel> productList=productdao.retriveProduct(product);
				List<CategoryModel> categoryList = categorydao.retriveCategory(null);
				for(CategoryModel cm:categoryList){
					System.out.println(cm.getName());
				}
				List<SupplierModel> supplierList =  supplierdao.retriveSupplier(null);
				for(SupplierModel cm:supplierList){
					System.out.println(cm.getName());
				}
				
				ModelAndView mv=new ModelAndView("/product");
				mv.addObject("result",productList);
				mv.addObject("category_dropdown",categoryList);
				mv.addObject("supplier_dropdown",supplierList);
				
				return mv;
			
			}
			
			@RequestMapping(value="product", method=RequestMethod.POST)			
		    public ModelAndView getProduct(ProductModel product,@RequestParam("operation") String operation	)
			{
				ModelAndView mv=new ModelAndView("/product","product",new ProductModel());
				if(operation.equalsIgnoreCase("add")){
					System.out.println("Product List Controller Passed");
					
					productdao.addProduct(product);
					List<ProductModel> productList=productdao.retriveProduct(null);
					List<CategoryModel> categoryList = categorydao.retriveCategory(null);
					
					List<SupplierModel> supplierList =  supplierdao.retriveSupplier(null);
					mv.addObject("category_dropdown",categoryList);
					mv.addObject("supplier_dropdown",supplierList);
					

					 mv=new ModelAndView("/product","result",productList);
					
				}
				else if(operation.equalsIgnoreCase("retrive")){
					List<ProductModel> productList=productdao.retriveProduct(product);
					
					mv=new ModelAndView("/product","result",productList);
				}
				else if(operation.equalsIgnoreCase("update")){
					productdao.updateProduct(product);
				}
				return mv;
			}
				@RequestMapping(value = "deleteproduct", method = RequestMethod.GET) 
				public ModelAndView deleteProduct(@RequestParam("id") String id) {
					System.out.println("Delete Controller Reached");
					ProductModel product =new ProductModel();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+id);
					product.setId(id);
					
					
					productdao.deleteProduct(product);
					List<ProductModel> productList=productdao.retriveProduct(null);

					ModelAndView mv=new ModelAndView("/product","result",productList);
				
					return mv ;		
				
			}
				
	}		




	 



