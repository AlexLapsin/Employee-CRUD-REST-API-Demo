package com.projects.springboot.cruddemo.dao;

import java.util.List;

import com.projects.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
