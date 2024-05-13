package com.bank.dept.dao;

import java.util.List;

import com.bank.dept.model.Department;

public interface DeptDAO {
	public List<Department> getAll();

	public Department getById(int deptno);

	public int save(Department dept);

	public int Update(Department dept,int deptno);

	public int delete(int deptno);
}
