package com.niit.dao;
import java.util.List;

import com.niit.model.CategoryModel;

public interface CategoryDAO {
	public void addCategory(CategoryModel category);
	public List<CategoryModel> retriveCategory(CategoryModel category);
	public void updateCategory(CategoryModel category);
	public void deleteCategory(CategoryModel category);
	

}
