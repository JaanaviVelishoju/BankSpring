package com.bank.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dept.dao.DeptDAO;
import com.bank.dept.model.Department;

@RestController
public class DeptController {
	@Autowired
	DeptDAO dDAO;

	@GetMapping("/dept")
	public List<Department> getAllDepartment() {
		return dDAO.getAll();
	}
	
	@GetMapping("/dept/{deptno}")
	public Department getDepartmentByNo(@PathVariable int deptno) {
		return dDAO.getById(deptno);
	}
	
	@PostMapping("/dept")
	public String saveDepartment(@RequestBody Department dept) {
		return dDAO.save(dept)+" No.of records affected in database";
	}
	 
	@PutMapping("/dept/{deptno}")
	public String updateDepartment(@RequestBody Department dept,@PathVariable int deptno) {
		return dDAO.Update(dept, deptno)+" No.of records updated in database";
	}
	 
	@DeleteMapping("/dept/{deptno}")
	public String deleteDepartment(@PathVariable int deptno)//@PathVariable annotation which tells the web service where it 
	//should receive your input to produce the response so it did not know where I should be passing my input. 
	{
		return dDAO.delete(deptno)+" No. of records deleted in database";
	}
	
	
	
}
