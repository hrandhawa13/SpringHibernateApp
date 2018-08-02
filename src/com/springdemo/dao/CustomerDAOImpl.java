package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Inject Session Factory
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current session
		Session session = factory.getCurrentSession();
		//create query
		Query<Customer> query = session.createQuery("from Customer order by last_name", Customer.class);
		//return results from query
		return query.getResultList();
	}

	@Override
	public void save(Customer temp) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(temp);	
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
