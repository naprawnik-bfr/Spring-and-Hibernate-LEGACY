package com.blaze.springboot.o50thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaze.springboot.o50thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's all!
	
	//add a method to sort by last name:
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
