package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		List<Employee> employees= empService.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
	{
		Employee employee = empService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee newEmployee = empService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
		
	}
	@PutMapping("/employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updatedEmployee = empService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
	{
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
