
package com.niit.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CategoryModel;
import com.niit.model.SupplierModel;
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	
public void addSupplier(SupplierModel supplier) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(supplier);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}


public List<SupplierModel> retriveSupplier(SupplierModel supplier) {
	List<SupplierModel> ll=null;
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		if(supplier!=null&&supplier.getId()!=null){
		Query<SupplierModel> qry = session.createQuery("from SupplierModel where id='"+supplier.getId()+"'");
		 ll = qry.getResultList();
		}
		else{
			Query<SupplierModel> qry = session.createQuery("from SupplierModel");
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
public void updateSupplier(SupplierModel supplier) {
	
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(supplier);
		trans.commit();
		session.flush();
		session.close();
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
}
public void deleteSupplier(SupplierModel supplier) {
	
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.delete(supplier);
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










