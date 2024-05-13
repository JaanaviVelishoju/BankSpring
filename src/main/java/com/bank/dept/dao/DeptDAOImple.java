package com.bank.dept.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bank.dept.model.Department;

@Repository
public class DeptDAOImple implements DeptDAO{
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<Department> getAll() {
		return jdbctemplate.query("SELECT * FROM department", new BeanPropertyRowMapper<Department>(Department.class));
	}

	@Override
	public Department getById(int deptno) {
		return jdbctemplate.queryForObject("SELECT * FROM department WHERE deptno=?", new BeanPropertyRowMapper<Department>(Department.class),deptno);
	}

	@Override
	public int save(Department dept) {
		return jdbctemplate.update("INSERT INTO department(deptno,dname,location) VALUES(?,?,?)",
				new Object[] {dept.getDeptno(),dept.getDname(),dept.getLocation()});
		
	}

	@Override
	public int Update(Department dept, int deptno) {
		return jdbctemplate.update("UPDATE department SET deptno=?,dname=?,location=? WHERE deptno=?", 
				new Object[] {dept.getDeptno(),dept.getDname(),dept.getLocation(),deptno});
	}

	@Override
	public int delete(int deptno) {
		return jdbctemplate.update("DELETE FROM department WHERE deptno=?",deptno);
	}

}
