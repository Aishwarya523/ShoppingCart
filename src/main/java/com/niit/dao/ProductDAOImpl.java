package com.niit.dao;
	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import com.niit.model.ProductModel;
import com.niit.model.SupplierModel;
	@Repository
	public class ProductDAOImpl implements ProductDAO {
		@Autowired
		SessionFactory sessionFactory;
		
	public void addProduct(ProductModel product) {
			
			try
			{
				Session session=sessionFactory.openSession();
				Transaction trans=session.beginTransaction();
				session.saveOrUpdate(product);
				trans.commit();
				session.flush();
				session.close();
			}
			
			catch(Exception ex)
			{
				System.out.println("Error="+ex);
			}
		}


	public List<ProductModel> retriveProduct(ProductModel product) {
		List<ProductModel> ll=null;
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();  
			if(product!=null&&product.getId()!=null){
			Query<ProductModel> qry = session.createQuery("from ProductModel where id='"+product.getId()+"'");
			 ll = qry.getResultList();
			}
			else{
				Query<ProductModel> qry = session.createQuery("from ProductModel");
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
	
	public List<ProductModel> retriveProductForCateg(ProductModel product) {
		List<ProductModel> ll=null;
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();  
			Query<ProductModel> qry = session.createQuery("from ProductModel where CATEGORYID='"+product.getCategoryId()+"'");
			ll = qry.getResultList();

			session.getTransaction().commit();
		    session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
			
		}
		return ll;
		
	}
	public void updateProduct(ProductModel product) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.update(product);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}
	public void deleteProduct(ProductModel product) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.delete(product);
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







