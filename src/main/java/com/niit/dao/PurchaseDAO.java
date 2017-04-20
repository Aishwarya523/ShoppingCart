package com.niit.dao;
import java.util.List;

import com.niit.model.CategoryModel;
import com.niit.model.OrderModel;

public interface PurchaseDAO {
	public void saveOrder(OrderModel order);
	public List<OrderModel> getOrder(OrderModel order);
	

}
