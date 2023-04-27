package com.blazefraczek.o46cruddemo.service;

import java.util.List;

import com.blazefraczek.o46cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee); 
	
	public void deleteById(int theId);
}
