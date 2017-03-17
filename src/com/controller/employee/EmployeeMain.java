package com.controller.employee;

import java.util.ArrayList;


public class EmployeeMain{
	ArrayList<EmployeeData> elist=new ArrayList<EmployeeData>();
	
	public void setElist(ArrayList<EmployeeData> elist) {
		this.elist = elist;
	}
	public ArrayList<EmployeeData> getElist() {
				return elist;
	}
	public EmployeeMain(){
		EmployeeData edata=new EmployeeData(1001,"Diya","IT","Communication","pid_100");
		EmployeeData emp=new EmployeeData(1002,"John","Development","Java","pid_2091");
		EmployeeData emp1=new EmployeeData(1234,"Heera","Support","DataAcces","pid_908");
		EmployeeData emp2=new EmployeeData(1111,"Athira","Support","WebServices","pid_2008");
		EmployeeData emp3=new EmployeeData(1003,"Arathi","IT","WebServices","pid_8908");
		EmployeeData emp4=new EmployeeData(2222,"Sreehari","IES","C#","pid_945");
		EmployeeData emp5=new EmployeeData(2333,"Jis","Development","Java","pid_0123");
		
		elist.add(edata);
		elist.add(emp);
		elist.add(emp1);
		elist.add(emp2);
		elist.add(emp3);
		elist.add(emp4);
		elist.add(emp5);
	}
}


