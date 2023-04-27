package com.blazefraczek.o46cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazefraczek.o46cruddemo.entity.Employee;

// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's all!
	
}
