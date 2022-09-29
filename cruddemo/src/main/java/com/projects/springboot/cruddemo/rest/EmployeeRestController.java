package com.projects.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springboot.cruddemo.entity.Employee;
import com.projects.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private	EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of all employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	// Add mapping for GET "/employees/{employeeId}"
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int theId){
		Employee theEmployee = employeeService.findById(theId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + theId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST "/employees" - add a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// this is to force save of new item instead of update
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
}
