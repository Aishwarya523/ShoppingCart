package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDAO;
import com.niit.dao.PurchaseDAO;
import com.niit.model.CategoryModel;
import com.niit.model.OrderModel;
import com.niit.model.ProductModel;

@Controller
public class PurchaseController {

	@Autowired
	ProductDAO productDao;
	
	@Autowired
	PurchaseDAO purchaseDao;
	
	@RequestMapping(value="showcase", method=RequestMethod.GET)
	public ModelAndView getProducts(ProductModel product,@RequestParam("categoryId") String categoryId	)
	{
		System.out.println("111111111111");
		ModelAndView mv=new ModelAndView("/showcase","product",new ProductModel());
		product.setCategoryId(categoryId);
		List<ProductModel> productList=productDao.retriveProductForCateg(product);
		for(ProductModel pm:productList){
			System.out.println(pm.getName());
		}
		mv.addObject("result",productList);
		return mv;
	}
	@RequestMapping(value="buynow", method=RequestMethod.POST)
	public ModelAndView buyNow(ProductModel product,@RequestParam("qty") String qty, @RequestParam("pid") String pid)
	{
		System.out.println("111111111111aaaa");
		ModelAndView mv=new ModelAndView("/shipping","product",new ProductModel());
		product.setId(pid);
		List<ProductModel> productList=productDao.retriveProduct(product);
		mv.addObject("result",productList);
		
		mv.addObject("qty",qty);
		return mv;
	}
	@RequestMapping(value="payNow", method=RequestMethod.POST)
	public ModelAndView payNow(OrderModel order)
	{
		System.out.println("111111111111wwwwww");
		ModelAndView mv=new ModelAndView("/payment","order",order);
		System.out.println(order.getAmount());
		
		//product.setId(pid);
				//mv.addObject("qty",qty);
		return mv;
	}
	
	@RequestMapping(value="paymentConfirm", method=RequestMethod.POST)
	public ModelAndView paymentConfirm(OrderModel order)
	{
		System.out.println("order Payment");
		ModelAndView mv=new ModelAndView("/paymentConfirm","order",order);
		purchaseDao.saveOrder(order);
		List<OrderModel> orders = purchaseDao.getOrder(order);
		mv.addObject("result",orders);
		//product.setId(pid);
				//mv.addObject("qty",qty);
		return mv;
	}
	
}
