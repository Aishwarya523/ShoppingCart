package com.niit.dao;

import java.util.List;
import com.niit.model.CustomerModel;

public interface CustomerDAO {
	public void addCustomer(CustomerModel customer);
	public List<CustomerModel> retriveCustomer(CustomerModel customer);
	public void updateCustomer(CustomerModel customer);
	public void deleteCustomer(CustomerModel customer);
	public List<CustomerModel> validateLogin(CustomerModel customer);
}
