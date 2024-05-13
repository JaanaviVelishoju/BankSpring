package com.bank.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.emp.dao.EmpDAO;
import com.bank.emp.model.Employee;

@RestController
public class EmpController {
	@Autowired
	EmpDAO eDAO;
	
	@GetMapping("/emp")
public List<Employee> getAllEmployee() {
	return eDAO.getAll();
}
	@GetMapping("/emp/{empid}")
	public Employee getEmployeeById(@PathVariable int empid) {
		return eDAO.getById(empid);
	}
//	@GetMapping("/emp/empid") //url =localhost:8080/emp/empid?empid=101
//	public Employee getEmployeeById(@RequestParam int empid) {
//		return eDAO.getById(empid);
//	}
	
	@PostMapping("/emp")
	public String saveEmployee(@RequestBody Employee employee) {
		return eDAO.save(employee)+" No. of records affected in database";
	}
	
	@PutMapping("/emp/{empid}")
	public String updateEmployee(@RequestBody Employee employee,@PathVariable int empid) {
		return eDAO.Update(employee, empid)+" No. of records updated in database";
	}
	@DeleteMapping("/emp/{empid}")
	public String deleteEmployee(@PathVariable int empid) {
		return eDAO.delete(empid)+" No. of records deleted from database";
	}
}
