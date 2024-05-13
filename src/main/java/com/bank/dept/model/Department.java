package com.bank.dept.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Department {
	
private int deptno;
private String dname;
private String location;
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
