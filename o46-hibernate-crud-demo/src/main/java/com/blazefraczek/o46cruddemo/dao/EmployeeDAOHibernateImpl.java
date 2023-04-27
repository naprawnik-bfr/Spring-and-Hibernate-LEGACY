package com.blazefraczek.o46cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blazefraczek.o46cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for EntityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get current hiernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a querry
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);	
		
		//execute querry and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		//get current hiernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee 
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void save(Employee theEmployee) {
		
		//get current hiernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save the employee 
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteById(int theId) {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Employee where id=: eployeeId");	
		theQuery.setParameter("eployeeId", theId);
		theQuery.executeUpdate();
		
	}

}
