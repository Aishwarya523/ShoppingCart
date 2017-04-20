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
import com.niit.dao.SupplierDAO;
import com.niit.model.CategoryModel;
import com.niit.model.SupplierModel;

	@Controller
	public class SupplierController {
		@Autowired
			SupplierDAO supplierdao;
			
			@RequestMapping(value="supplier",method=RequestMethod.GET)
			public ModelAndView sendsupplier(@ModelAttribute("supplier") SupplierModel supplier)
			{
				List<SupplierModel> supplierList=supplierdao.retriveSupplier(supplier);

				ModelAndView mv=new ModelAndView("/supplier","result",supplierList);
				return mv;
			}
			
			@RequestMapping(value="supplier", method=RequestMethod.POST)
			
		    public ModelAndView getSupplier(SupplierModel supplier,@RequestParam("operation") String operation	)
			{
				ModelAndView mv=new ModelAndView("/supplier","supplier",new SupplierModel());
				if(operation.equalsIgnoreCase("add")){
					supplierdao.addSupplier(supplier);
					List<SupplierModel> supplierList=supplierdao.retriveSupplier(null);

					 mv=new ModelAndView("/supplier","result",supplierList);
					
				}
				else if(operation.equalsIgnoreCase("retrive")){
					List<SupplierModel> supplierList=supplierdao.retriveSupplier(supplier);

					mv=new ModelAndView("/supplier","result",supplierList);
				}
				else if(operation.equalsIgnoreCase("update")){
					supplierdao.updateSupplier(supplier);
				}
				return mv;
			}
				@RequestMapping(value = "deletesupplier", method = RequestMethod.GET) 
				public ModelAndView deleteCategory(@RequestParam("id") String id) {
					System.out.println("Delete Controller Reached");
					SupplierModel supplier =new SupplierModel();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+id);
					supplier.setId(id);
					
					
					supplierdao.deleteSupplier(supplier);
					List<SupplierModel> supplierList=supplierdao.retriveSupplier(null);

					ModelAndView mv=new ModelAndView("/supplier","result",supplierList);
				
					return mv ;		
				
			}


		}





	 




	


