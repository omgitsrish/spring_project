package com.ebs.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebs.model.Account;

@Component
public class Employee_has_Project {
	private int emp_id;
	private int proj_id;
	private String date_from;
	private String date_to;
	private Account account;
	public String getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}
	public String getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
	
	
	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
		
	public List<Employee_has_Project> getAllEmphasProj(){
		
		return account.getAllEmphasProj();
	}
	
}
