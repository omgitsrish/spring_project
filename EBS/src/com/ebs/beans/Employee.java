package com.ebs.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebs.model.Account;

@Component
public class Employee {
	private static int count=1;
	private int emp_id;
	private String emp_name;
	private String emp_address;
	private String username;
	private String emp_joindate;
	private String emp_leavedate;
	private String emp_salary;
	private Account account;
	private String password;
	private String enabled;
	
	
	public int getCount() {
		count+=1;
		return count;
	}
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmp_joindate() {
		return emp_joindate;
	}

	public void setEmp_joindate(String emp_joindate) {
		this.emp_joindate = emp_joindate;
	}

	public String getEmp_leavedate() {
		return emp_leavedate;
	}

	public void setEmp_leavedate(String emp_leavedate) {
		this.emp_leavedate = emp_leavedate;
	}


	public String getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(String emp_salary) {
		this.emp_salary = emp_salary;
	}

	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	public void addEmployee(Employee e) {
		account.addEmployee(e);
	}
	
	public List<Employee> getAllEmployee(){
		return account.getAllEmployee();
	}
	
	public void addEmployeeToProject(int emp_id,Project p) {
		account.addEmployeeToProject(emp_id,p);
	}

}
