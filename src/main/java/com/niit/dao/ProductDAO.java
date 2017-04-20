package com.niit.dao;
	import java.util.List;

import com.niit.model.ProductModel;

	public interface ProductDAO {
		public void addProduct(ProductModel product);
		public List<ProductModel> retriveProduct(ProductModel product);
		public List<ProductModel> retriveProductForCateg(ProductModel product);
		public void updateProduct(ProductModel product);
		public void deleteProduct(ProductModel product);
		

	}


