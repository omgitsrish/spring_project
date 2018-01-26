package com.ebs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ebs.beans.EHP;
import com.ebs.beans.Employee;
import com.ebs.beans.Project;

@Controller
public class ProjectController {

	Project project;
	Employee employee;
	EHP ehp;
	@Autowired
	public void setProject(Project project) {
		this.project = project;
	}
	@Autowired
	public void setEhp(EHP ehp) {
		this.ehp = ehp;
	}
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@RequestMapping(value="/AddProject", method=RequestMethod.POST)
	public ModelAndView addProject(Model model,HttpServletRequest request,Project p){
		
		//go to DB with Project (Service Layer) and insert project
		project.addProject(p);
		//go to DB via Employee bean and get all employees 
		ArrayList<Employee> emp_list = employee.getAllEmployees();
		ArrayList<Project> proj_list = project.getAllProjects();
		
		request.getSession().setAttribute("emp_list", emp_list);
		request.getSession().setAttribute("proj_list", proj_list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("proj", p);
		mav.setViewName("project");
		model.addAttribute("msg","Project: " + p.getName() + " Added to the system");
		return mav;
	}
	
	@RequestMapping(value="/showProjectReport",method=RequestMethod.POST)
	public ModelAndView showProjectReport(@RequestParam(value="pid") String pid, Model model){
		//go to DB via EHP class and fetch employee_has_project table 
		ArrayList<EHP> list = ehp.fetch(pid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("show_project_report");
		return mav;
	}
	
	@RequestMapping(value="/ChangeManager",method=RequestMethod.POST)
	public String ChangeManager(@RequestParam(value="pid") String pid, @RequestParam(value="eid") String eid, Model model){
		//go to DB via project and insert pid,eid,date in employee_has_project table 
		project.changeManager(pid,eid);
		model.addAttribute("msg", "Project Records Updated ");
		return "redirect:/project";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/SendMessage",method=RequestMethod.POST)
	public String sendMessage(HttpServletRequest request, Model model  ) {
		ArrayList<Employee> elist = new ArrayList<>();
		ArrayList<Employee> ex=employee.getAllEmployees();
		String message=request.getParameter("message");
		model.addAttribute("message", message);
		
		String project_id=request.getParameter("project");
		model.addAttribute("name", (String)project_id);
		System.out.println(project_id);
		ArrayList<EHP> e=ehp.fetch(project_id);
		
		System.out.println(e.toString());
		
		for(EHP e1:e) {
			for(Employee e2:ex) {
				System.out.println(e1.getEid()+"---"+e2.getId());
				if(e1.getEid()==e2.getId()) {
					System.out.println("Its a match, adding"+e2.getId()+"---"+e2);
					elist.add(e2);
					System.out.println("Yep");
				}
			}
		}
		System.out.println("Comes till here");
			for(Employee e3:elist) {
				System.out.println("Id:"+e3.getId());
			}
			model.addAttribute("ehp",elist);
		//request.getSession().setAttribute("ehp", elist);
		return "message_sent";
	}
	
}
