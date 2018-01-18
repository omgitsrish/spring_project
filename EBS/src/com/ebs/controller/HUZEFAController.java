package com.ebs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.SSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("list", sal.getEmployeeSalary());
		return "giveincrement";
	}
	
	@RequestMapping(value="/empid_selected")
	public String empidSelected(@RequestParam("id") String id, Model model,HttpServletRequest request) {
		model.addAttribute("id",id);
		System.out.println("Works till /empidselected");
		return "howmuchincrement";
	}
	
	@RequestMapping(value="/input_increment")
	public String inputIncrement(@RequestParam ("new_id") String id, HttpServletRequest request,Model model) {
		int increment=Integer.parseInt(request.getParameter("increment"));
	
		System.out.println("id="+id+"increment="+increment);
		sal.giveIncrement(Integer.parseInt(id),increment,new Salary());
		
		
		return "successfulincrement";
	}
	
	
	
	
	

	@Autowired
	public void setSal(Salary sal) {
		this.sal = sal;
	}
	
	
	
	
	
}
