package com.ebs.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.ebs.beans.Employee_has_Project;
import com.ebs.beans.Project;

@Controller
public class EmployeeController {
	
	Employee employee;
	private TreeSet<Employee> list_search = new TreeSet<>();
	private Project project;
	private Employee_has_Project ep;
	


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
	@SuppressWarnings("unchecked")
	@RequestMapping("SearchEmployeeByEmail")
	public String searchEmployeeByEmail(Model model,HttpServletRequest request,@RequestParam(value="search") String search_email){
		//all the employees are already extracted in emp_list. 
		list_search.clear();
		
		ArrayList<Employee> elist = (ArrayList<Employee>)request.getSession().getAttribute("emp_list");
				for( Employee  e : elist){
					if(e.getEmail().contains(search_email)){
						list_search.add(e);
					}
				}
		model.addAttribute("search_email",search_email);
		model.addAttribute("list_search",list_search);
		
		return "employee_search";
	}
		
	@RequestMapping("/SearchEmployeeByProject")
		public String searchEmployeeByProject(Model model,HttpServletRequest request,@RequestParam(value="search") String search_project){
		//all the employees are already extracted in emp_list.
		
		List<Project> list=project.getAllProjects();
		int proj_id=0;
		int emp_id=0;
		for(Project p:list) {
			if(search_project.equals(p.getName())) {
				 proj_id = p.getId();
				
				
			}
		}
		
		
		List<Employee_has_Project> listehp = ep.getAllEmphasProj();
		for(Employee_has_Project ehp1:listehp) {
			if(ehp1.getProj_id()==proj_id) {
				emp_id=ehp1.getEmp_id();
		
			}
		}
		
		List<Employee> listemp = employee.getAllEmployees();
		for(Employee e:listemp) {
			if(emp_id==e.getId()) {
				list_search.add(e);
				
			}
			
		}
		
		model.addAttribute("search_project",search_project);
		model.addAttribute("list_search",list_search);
		return "employee_search";
	}
	
	@RequestMapping("AssignEmployeeToProject")
	public String assignEmployee(){
		return "employee";
	}
	
	@RequestMapping("UnAssignEmployeeToProject")
	public String unassignEmployee(){
		return "employee";
	}
	
	@Autowired
	public void setEp(Employee_has_Project ep) {
		this.ep = ep;
	}

	@Autowired
	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
