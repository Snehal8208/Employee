package com.spring.employee.serviceIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee.Employee_repo;
import com.spring.employee.dto.Employee;
import com.spring.employee.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
	@Autowired
	private Employee_repo employee_repo;

	@Override
	public Employee addEmployee(Employee employee) {

		Employee emp = employee_repo.save(employee);
		return emp;
	}

	@Override
	public String removeEmployee(int id) {
		employee_repo.deleteById(id);
		return "Delete data Successfully";
	}

	@Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> emp = employee_repo.findById(id);
		if (emp.isPresent()) {
			return emp;
		}
		return null;
	}

	@Override
	public String updateEmployee(int id) {
		Optional<Employee> emp = employee_repo.findById(id);
		if (emp.isPresent()) {
			Employee employee1 = new Employee();
			employee_repo.save(employee1);
			return "UPdated Successfully";
		} else {
			return "Employee not found";
		}

	}

	
}
