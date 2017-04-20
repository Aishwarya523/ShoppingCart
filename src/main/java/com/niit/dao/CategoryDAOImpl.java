package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CategoryModel;


@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	
public void addCategory(CategoryModel category) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(category);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}


public List<CategoryModel> retriveCategory(CategoryModel category) {
	List<CategoryModel> ll=null;
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		if(category!=null&&category.getProductid()!=null){
		Query<CategoryModel> qry = session.createQuery("from CategoryModel where productid='"+category.getProductid()+"'");
		 ll = qry.getResultList();
		}
		else{
			Query<CategoryModel> qry = session.createQuery("from CategoryModel");
			ll = qry.getResultList();
		}
		session.getTransaction().commit();
	    session.close();

		
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
		
	}
	return ll;
	
}
public void updateCategory(CategoryModel category) {
	
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(category);
		trans.commit();
		session.flush();
		session.close();
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
}
public void deleteCategory(CategoryModel category) {
	
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.delete(category);
		trans.commit();
		session.flush();
		session.close();
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
}

}
