package com.ebs.controller;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebs.beans.EmpIncr;
import com.ebs.beans.Employee;
import com.ebs.beans.Project;

@Controller
public class EmployeeController {
	
	Employee employee;
	Project project;
	
	private TreeSet<Employee> list_search = new TreeSet<>();
	
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Autowired
	public void setProject(Project project) {
		this.project = project;
	}

	@RequestMapping(value="/AddEmployee",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee e ,Model model, HttpServletRequest request){
		model.addAttribute("msg", "Employee " + e.getName()  +" is added to the System ");
		//Go to Account via Employee and insert record
		employee.addEmployee(e);
		ArrayList<Employee> emp_list = employee.getAllEmployees();
		ArrayList<Project> proj_list = project.getAllProjects();
		request.getSession().setAttribute("emp_list", emp_list);
		request.getSession().setAttribute("proj_list", proj_list);
		return "redirect:/employee";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/SearchEmployeeByName",method=RequestMethod.POST)
	public String searchEmployeeByName(Model model,HttpServletRequest request, @RequestParam(value="search") String search_name){
		//all the employees are already extracted in emp_list. 
				
		list_search.clear();
				ArrayList<Employee> elist = (ArrayList<Employee>)request.getSession().getAttribute("emp_list");
						for( Employee  e : elist){
							if(e.getName().contains(search_name)){
								list_search.add(e);
							}
						}
			model.addAttribute("search",search_name);	
			model.addAttribute("list_search",list_search);
			
			return "employee_search";
	}
	
	@RequestMapping("SearchEmployeeByEmail")
	public String searchEmployeeByEmail(Model model,@RequestParam(value="search") String search_email){
		//all the employees are already extracted in emp_list. 
		model.addAttribute("search_email",search_email);
		
		return "redirect:/employee#record";
	}
	
	@RequestMapping("SearchEmployeeByProject")
	public String searchEmployeeByProject(){
		return "employee";
	}
	
	@RequestMapping("AssignEmployeeToProject")
	public String assignEmployee(@RequestParam(value="eid") String eid,@RequestParam(value="pid") String pid,Model model){
		//assign
		employee.assignEmployee(eid,pid);
		model.addAttribute("emp",new Employee());
		model.addAttribute("msg","Employee assigned to project successfully");
		return "employee";
	}
	
	@RequestMapping("UnAssignEmployeeToProject")
	public String unassignEmployee(){
		return "employee";
	}
	
	@RequestMapping("showIncrementReport")
	public String showIncrementReport(@RequestParam(value="eid") String eid,Model model){
		//go to DB via Employee and get record of all increments of eid from salary_record table
		ArrayList<EmpIncr> list  = employee.getSalaryRecord(eid);
		model.addAttribute("list",list);
		return "increment_report";
	}
	
	@RequestMapping("IncrementSalary")
	public String incrementSalary(@RequestParam(value="eid") String eid,@RequestParam(value="increment_sal") String sal,Model model,HttpServletRequest request){
		//go to db via EMployee and update salary in employee and add record in salary_record using trigger
		employee.incrementSalary(eid,sal);
		model.addAttribute("msg", "Salary Updated");
		ArrayList<Employee> emp_list = employee.getAllEmployees();
		request.getSession().setAttribute("emp_list", emp_list);
		return "salary_record";
	}
}
