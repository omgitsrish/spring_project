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

import com.ebs.beans.Employee;

@Controller
public class EmployeeController {
	
	Employee employee;
	private TreeSet<Employee> list_search = new TreeSet<>();
	
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@RequestMapping(value="/AddEmployee",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee e ,Model model, HttpServletRequest request){
		model.addAttribute("msg", "Employee " + e.getName()  +" is added to the System ");
		//Go to Account via Employee and insert record
		employee.addEmployee(e);
		@SuppressWarnings("unchecked")
		ArrayList<Employee> list = (ArrayList<Employee>)request.getSession().getAttribute("emp_list");
		list.add(e);
		request.getSession().setAttribute("emp_list", list);
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
	public String assignEmployee(){
		return "employee";
	}
	
	@RequestMapping("UnAssignEmployeeToProject")
	public String unassignEmployee(){
		return "employee";
	}
}
