package com.spring.employee.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.dto.Employee;
import com.spring.employee.serviceIMPL.EmployeeServiceIMPL;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeServiceIMPL employeeservice;

    public EmployeeController(EmployeeServiceIMPL employeeservice) {
        this.employeeservice = employeeservice;
    }

    @PostMapping("/addEmp")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        employeeservice.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully");
    }

	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id) {
		employeeservice.removeEmployee(id);
		return new ResponseEntity<String>("Removed Successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = employeeservice.findById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Employee>>(HttpStatus.NOT_FOUND);
		}
	}

}
