package com.ebs.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ebs.model.Account;

@Controller
public class Message {
	private int mid;
	private String from_emp;
	private String to_emp;
	private String date;
	private String message;
	
	private Account account;
	
	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getFrom_emp() {
		return from_emp;
	}
	public void setFrom_emp(String from_emp) {
		this.from_emp = from_emp;
	}
	public String getTo_emp() {
		return to_emp;
	}
	public void setTo_emp(String to_emp) {
		this.to_emp = to_emp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
