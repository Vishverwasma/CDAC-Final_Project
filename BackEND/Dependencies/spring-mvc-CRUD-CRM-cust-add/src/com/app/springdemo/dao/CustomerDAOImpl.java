package com.app.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
//	public CustomerDAOImpl(SessionFactory sessionFactory) {
//		super();
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	public List<Customer> getCustomers() {
		//get current hibernate Session
				Session currentSession = sessionFactory.getCurrentSession();
				//create a query.... sort by last name
				Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
				//execute query and get result set
					List<Customer> customers= query.getResultList();
				//return the results
				return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the Customer
		currentSession.save(theCustomer);

	}

}
