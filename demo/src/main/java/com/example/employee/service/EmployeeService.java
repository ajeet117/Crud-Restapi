package com.example.employee.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.exception.UserNotFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService  {
	@Autowired
	private  EmployeeRepository empRepo;
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return empRepo.save(employee);
	}
	public List<Employee> findAll()
	{
		return empRepo.findAll();
	}
	public Employee updateEmployee(Employee employee)
	{
		return empRepo.save(employee);
	}
	public Employee findEmployeeById(Long id)
	{
		return empRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User not found by id" + id));
	}
	public void deleteEmployee(Long id) {
		empRepo.deleteEmployeeById(id);
	}
}
