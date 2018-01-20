package com.ebs.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebs.model.Account;
import com.ebs.model.AccountAli;

@Component
public class Project {
	private static int count;
	private int proj_id;
	private String proj_name;
	private String proj_start_date;
	private String proj_estimated_end_date;
	private String proj_end_date;
	private String proj_client_name;
	private String budget;
	private String status;
	private Account account;
	private AccountAli accountali;
	
	
	public int getCount() {
		count+=1;
		return count;
	}
@Autowired
	public void setAccountali(AccountAli accountali) {
		this.accountali = accountali;
	}



	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	
	
	public int getProj_id() {
		return proj_id;
	}



	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}



	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public String getProj_start_date() {
		return proj_start_date;
	}

	public void setProj_start_date(String proj_start_date) {
		this.proj_start_date = proj_start_date;
	}

	public String getProj_estimated_end_date() {
		return proj_estimated_end_date;
	}

	public void setProj_estimated_end_date(String proj_estimated_end_date) {
		this.proj_estimated_end_date = proj_estimated_end_date;
	}

	public String getProj_end_date() {
		return proj_end_date;
	}

	public void setProj_end_date(String proj_end_date) {
		this.proj_end_date = proj_end_date;
	}

	public String getProj_client_name() {
		return proj_client_name;
	}

	public void setProj_client_name(String proj_client_name) {
		this.proj_client_name = proj_client_name;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Project> getAllProjects(){
		return account.getAllProjects();
	}


	public void addProject(Project p) {
		accountali.addProject(p);		
	}

}
