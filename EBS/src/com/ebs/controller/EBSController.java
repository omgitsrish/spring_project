package com.ebs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebs.beans.Employee;
import com.ebs.beans.Project;

@Controller
public class EBSController {
	private Employee employee;
	private Project project;
	
	@Autowired
	public void setProject(Project project) {
		this.project = project;
	}

	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@RequestMapping("/")
	public String showHome(){
		return "index";
	}
	
	@RequestMapping("/project")
	public String showProject(Model model){
		model.addAttribute("project",new Project());
		return "project";
	}
	@RequestMapping("/salary")
	public String showSalary(){
		return "salary_record";
	}
	@RequestMapping("/employee")
	public String showEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "employee";
	}
	@RequestMapping("/search")
	public String showSearch(){
		return "search";
	}
	
	@RequestMapping(value="/Add-employee" , method= RequestMethod.POST )
	public String AddEmployee(Model model, Employee e	) {
		e.setEnabled("true");
		e.setEmp_id((int)(Math.random()*100));
		employee.addEmployee(e);
		return "employee";
	}
	
	@RequestMapping(value="/addtoproject" )
	public String AddToProject(Model model	) {
		model.addAttribute("status","true");
		model.addAttribute("list" , project.getAllProjects());
		return "addtoproject";
	}
	
	
	
	@RequestMapping(value="/Add-project" , method= RequestMethod.POST )
	public String AddProject(Model model, Project p	) {
		project.addProject(p);
		return "project";
	}
	
}
