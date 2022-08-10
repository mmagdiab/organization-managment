package com.ntg.organization.organization.controller;

import java.util.List;

import com.ntg.organization.organization.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.service.EmployeeService;

@RestController
@RequestMapping("/emp/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/all")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping(value = "/getByName/{name}/{email}")
	public Employee getEmployeeByName(@PathVariable String name, @PathVariable String email) {
		return employeeService.getEmployeeByName(name, email);
	}

	@PostMapping(value = "/add")
	public Employee createNewEmployee(@RequestBody Employee newEmp) {
		return employeeService.createNewEmployee(newEmp);
	}

	@DeleteMapping(value = "/del/{empId}")
	public boolean deleteEmployee(@PathVariable(value = "empId") Long id) {
		return employeeService.deleteEmployeeById(id);
	}

	@PutMapping("/assignDepartment")
	public boolean assignDepartment(@RequestParam Long depId,
									@RequestParam Long empId)  {
		return employeeService.assignDepartment(depId, empId);
	}

}
