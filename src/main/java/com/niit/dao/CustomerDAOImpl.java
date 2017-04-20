package com.niit.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.model.CustomerModel;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	

public void addCustomer(CustomerModel customer) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.save(customer);
			Query query = session.createSQLQuery("INSERT INTO authorities (username, role) VALUES ('"+customer.getUsername()+"','ROLE_USER')");
			query.executeUpdate();
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}

		public List<CustomerModel> retriveCustomer(CustomerModel customer) {
			List<CustomerModel> custom=null;
			try
			{
				Session session=sessionFactory.openSession();
				Transaction trans=session.beginTransaction();  

				Query<CustomerModel> qry = session.createQuery("from CustomerModel where username='"+customer.getUsername()+"'");
				 custom = qry.getResultList();
				
				session.getTransaction().commit();
			    session.close();
			}
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
			return custom;
}
			
		
		
public void updateCustomer(CustomerModel customer) {
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(customer);
		trans.commit();
		session.flush();
		session.close();
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
	
	
	
}
public void deleteCustomer(CustomerModel customer) {
	try
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.delete(customer);
		trans.commit();
		session.flush();
		session.close();
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
}
	

public List<CustomerModel> validateLogin (CustomerModel customer){
	 List<CustomerModel> listCustomer=null;
	 System.out.println("inside DAO"+customer);
	try
	{
		Session session=sessionFactory.openSession();
			
		Transaction trans=session.beginTransaction();
		
		
		Query<CustomerModel> qry = session.createQuery("from CustomerModel where username='"+customer.getUsername()+"' and password='"+customer.getPassword()+"'");
		
		 listCustomer = qry.getResultList();
		
		System.out.println(listCustomer.size());
	}
	
	catch(Exception ex)
	{
		System.out.println("Error="+ex);
	}
	return listCustomer;
}

}
	

