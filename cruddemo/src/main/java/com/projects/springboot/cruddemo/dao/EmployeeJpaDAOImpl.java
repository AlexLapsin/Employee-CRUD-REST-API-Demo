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
		// get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		// update with id from db ... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int theId) {
		
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
