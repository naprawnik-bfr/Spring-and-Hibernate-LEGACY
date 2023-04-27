package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// GAME PLAN FOR THIS METHOD:
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//!!!!!!!NO NEED FOR BEGIN AND COMMINT DUE TO @TRANSACTIONAL IN SERVICE
		// create a query...sorted by  last name
		Query<Customer> theQuery = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		
		// execute query and get result list 
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from the database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id = :customerId");
				theQuery.setParameter("customerId", theId);
				
		theQuery.executeUpdate();
	}	
}
