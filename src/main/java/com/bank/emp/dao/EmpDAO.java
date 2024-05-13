package com.bank.emp.dao;

import java.util.List;

import com.bank.emp.model.Employee;

public interface EmpDAO {
	public List<Employee> getAll();

	public Employee getById(int empid);

	public int save(Employee employee);

	public int Update(Employee employee,int empid);

	public int delete(int empid);
}
