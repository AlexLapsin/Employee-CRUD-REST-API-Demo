package com.projects.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeJpaDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		// Create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		// execute the query and get the result list
		List<Employee> employees = theQuery.getResultList();
		
		// return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int theId) {
		// TODO Auto-generated method stub

	}

}
