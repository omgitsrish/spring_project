package com.ebs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebs.beans.Employee;
import com.ebs.beans.Project;

@Controller
public class EBSController {
	private Employee employee;
	private Project project;
	private int emp_id;
	
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
	
	@RequestMapping("addtoproject")
	public String addtoproject(Model model){
		model.addAttribute("employee", new Employee());
		model.addAttribute("listOfEmp", employee.getAllEmployee());
		return "addtoproject";
	}
	
	@RequestMapping(value="/Add-employee" , method= RequestMethod.POST )
	public String AddEmployee(Model model, Employee e	) {
		e.setEnabled("true");
		e.setEmp_id((int)(Math.random()*10000));
		model.addAttribute("emp_name", e.getEmp_name());
		model.addAttribute("emp_id", e.getEmp_id());
		model.addAttribute("status", "fromEmp");
		employee.addEmployee(e);
		this.emp_id=e.getEmp_id();
		return "addtoproject";
	}
	
	@RequestMapping(value="/addNewEmpToProject" )
	public String AddToProject(Model model) {
		model.addAttribute("status","true");
		System.out.println(this.emp_id);
		model.addAttribute("project", new Project());
		model.addAttribute("listOfProjects" , project.getAllProjects());
		return "addtoproject";
	}
	
	
	
	@RequestMapping(value="/Add-project" , method= RequestMethod.POST )
	public String AddProject(Model model, Project p	) {
		project.addProject(p);
		return "project";
	}
	
	@RequestMapping("/addEmployeeToDb")
	public String AddEmployeeToDB(Model model, Project p) {
		employee.addEmployeeToProject(this.emp_id, p.getProj_id());
		return "employee";
	}
	
	
	
}
