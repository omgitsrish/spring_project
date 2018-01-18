package com.ebs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebs.beans.Salary;

@Controller
public class HUZEFAController {
	private Salary sal;
	
	@RequestMapping(value="/Give_Salary")
	public String getEmployeeCurrentSalary(Model model) {
		
		model.addAttribute("list", sal.getEmployeeSalary());
		
		return "salaryofemployees";
	}
	
	@RequestMapping(value="/Increment_Salary")
	public String salaryIncrement(Model model) {
		
	
		
		return "giveincrement";
	}
	
	
	

	@Autowired
	public void setSal(Salary sal) {
		this.sal = sal;
	}
	
	
	
	
	
}
