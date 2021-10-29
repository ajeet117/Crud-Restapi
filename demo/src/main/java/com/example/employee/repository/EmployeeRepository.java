package com.example.employee.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public void deleteEmployeeById(Long id);
	public Optional<Employee> findEmployeeById(Long id);
}
