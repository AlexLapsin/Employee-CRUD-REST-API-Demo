package com.projects.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// we get CRUD methods and more from JpaRepository 
	// so there is no need to write any employeeDAO interfaces/implementations
	
}
