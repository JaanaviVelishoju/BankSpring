package com.bank.emp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bank.emp.model.Employee;

@Repository
public class EmpDAOImpl implements EmpDAO{
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<Employee> getAll() {
		return jdbctemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee getById(int empid) {
		return jdbctemplate.queryForObject("SELECT * FROM employee WHERE empid=?", new BeanPropertyRowMapper<Employee>(Employee.class),empid);
	}

	@Override
	public int save(Employee employee) {
		return jdbctemplate.update("INSERT INTO employee(empid,ename,email,sal,deptno) VALUES(?,?,?,?,?)",
				new Object[] {employee.getEmpid(),employee.getEname(),employee.getEmail(),employee.getSal(),employee.getDeptno()});
	}

	@Override
	public int Update(Employee employee, int empid) {
		return jdbctemplate.update("UPDATE employee SET empid=?,ename=?,email=?,sal=?,deptno=? WHERE empid=?",new Object[] {employee.getEmpid(),employee.getEname(),employee.getEmail(),employee.getSal(),employee.getDeptno(),empid});
	}

	@Override
	public int delete(int empid) {
		return jdbctemplate.update("DELETE FROM employee WHERE empid=?",empid);
	}

}
