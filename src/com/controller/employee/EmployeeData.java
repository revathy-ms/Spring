package com.controller.employee;

public class EmployeeData {
	int eid;
	String ename,dept,domain,pid;
	
	public EmployeeData(){}
	public EmployeeData(int eid, String ename, String dept,String domain, String pid) {
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
		this.domain= domain;
		this.pid = pid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getEid() {
		return eid;
	}
	
	public String getEname() {
		return ename;
	}
	public String getDept() {
		return dept;
	}
	public String getDomain() {
		return domain;
	}
	public String getPid() {
		return pid;
	}
}