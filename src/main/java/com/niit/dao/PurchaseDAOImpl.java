package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CategoryModel;
import com.niit.model.OrderModel;
import com.niit.model.ProductModel;


@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	@Autowired
	SessionFactory sessionFactory;
	
public void saveOrder(OrderModel order) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(order);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}
	}

public List<OrderModel> getOrder(OrderModel order) {
	Session session=sessionFactory.openSession();
	Transaction trans=session.beginTransaction();
	List<OrderModel> ll=null;
	Query<OrderModel> qry = session.createQuery("from OrderModel where orderid="+order.getOrderId());
	ll = qry.getResultList();
	session.getTransaction().commit();
    session.close();
	// TODO Auto-generated method stub
	return ll;
}


}
