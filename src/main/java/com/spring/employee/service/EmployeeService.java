package com.spring.employee.service;

import java.util.Optional;

import com.spring.employee.dto.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);

	public String removeEmployee(int id);

	public Optional<Employee> findById(int id);

	public String updateEmployee(int id);
}
