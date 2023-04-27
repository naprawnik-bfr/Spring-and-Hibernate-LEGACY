package com.blazefraczek.o46cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blazefraczek.o46cruddemo.dao.EmployeeRepository;
import com.blazefraczek.o46cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Override

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override

	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;		
		
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
