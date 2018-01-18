package com.ebs.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebs.model.Account;

@Component
public class Salary {
	private int record_id;
	private String date;
	private String salary;
	private int emp_id;
	private Account account;
	public String getSalary() {
		return salary;
	}
	
	
	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Employee getE() {
		return e;
	}

	private Employee e;
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Autowired
	public void setE(Employee e) {
		this.e = e;
	}
	
	public List<Salary> getEmployeeSalary(){
		
		System.out.println("Works fine Salary");
		return account.getEmployeeCurrentSalary();
	}
	
	public List<Salary> getEmployeeId(){
		return account.getEmployeeId();
	}
	
}
