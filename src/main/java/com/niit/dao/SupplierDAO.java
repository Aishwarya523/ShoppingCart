package com.niit.dao;
	import java.util.List;
	import com.niit.model.SupplierModel;
	public interface SupplierDAO {
			public void addSupplier(SupplierModel supplier);
			public List<SupplierModel> retriveSupplier(SupplierModel supplier);
			public void updateSupplier(SupplierModel supplier);
			public void deleteSupplier(SupplierModel supplier);
			

		}









