package com.spring.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employee.dto.Employee;

public interface Employee_repo extends JpaRepository<Employee, Integer> {
	
}
