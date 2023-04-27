package com.blaze.springboot.o50thymeleafdemo.service;

import java.util.List;

import com.blaze.springboot.o50thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee); 
	
	public void deleteById(int theId);
}
