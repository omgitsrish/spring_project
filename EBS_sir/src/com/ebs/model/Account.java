package com.ebs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ebs.beans.Employee;
import com.ebs.beans.Project;

@Component
public class Account {
	private NamedParameterJdbcTemplate jdbc;
	private PasswordEncoder passenc;
	private Employee employee;
	private Project project ;
	
	@Autowired
	public void setProject(Project project) {
		this.project = project;
	}


	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public void setPassenc(PasswordEncoder passenc) {
		this.passenc = passenc;
	}

	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Employee> getAllEmployees() {
		// Extract all employees from DB
		return jdbc.query("select * from employee", new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e=new Employee();
				e.setId(rs.getInt("emp_id"));
				e.setName(rs.getString("emp_name"));
				e.setEmail(rs.getString("emp_email"));
				e.setAddress(rs.getString("emp_address"));
				e.setJoin_date(rs.getString("emp_joindate"));
				e.setLeave_date(rs.getString("emp_leavedate"));
				e.setSalary(rs.getString("emp_salary"));
				e.setUsername(rs.getString("username"));
				e.setJob_title(rs.getString("emp_job_title"));
				return e;
			}
			
		});
		
	}


	public List<Project> getAllProjects() {
		// Extract all projects from DB
				return jdbc.query("select * from project", new RowMapper<Project>(){

					@Override
					public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
						Project p =new Project();
						p.setId(rs.getInt("proj_id"));
						p.setName(rs.getString("proj_name"));
						p.setStart_date(rs.getString("proj_start_date"));
						p.setEstimated_end_date(rs.getString("proj_estimated_end_date"));
						p.setEnd_date(rs.getString("proj_end_date"));
						p.setClient_name(rs.getString("proj_client_name"));
						p.setBudget(rs.getString("budget"));
						p.setStatus(rs.getString("status"));
						return p;
					}
					
				});
	}


	public void addEmployee(Employee e) {
		// Insert e into DB
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("emp_name", e.getName());
		map.addValue("emp_email", e.getEmail());
		map.addValue("emp_address", e.getAddress());
		map.addValue("emp_joindate", e.getJoin_date());
		map.addValue("emp_leavedate", e.getLeave_date());
		map.addValue("emp_salary", e.getSalary());
		map.addValue("emp_job_title", e.getJob_title());
		map.addValue("username", e.getEmail());
		map.addValue("password", "000");
		map.addValue("authority", "employee");
		map.addValue("enabled", "true");

		jdbc.update("insert into employee(emp_name,emp_email,emp_address,emp_joindate,emp_leavedate,emp_salary,emp_job_title,username)"
				+ "values (:emp_name,:emp_email,:emp_address,:emp_joindate,:emp_leavedate,:emp_salary,:emp_job_title,:username)", map);
		jdbc.update("insert into users(username,password,enabled) values (:emp_email,:password,:enabled)", map);
		jdbc.update("insert into authorities(username,authority) values (:emp_email,:authority)", map);
	}
	
	/*
	public List<Product> getAllProducts(){
		return jdbc.query("select * from product", new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p =new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				p.setDesc(rs.getString("description"));
				return p;
			}
			
		});
		
	}


	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	public Product getSingleProduct(int id){
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.queryForObject("select * from product where id=:id", map ,new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p =new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				p.setDesc(rs.getString("description"));
				return p;
			}
			
		});
	}
	
	public void addEmployee(Student s){
	//BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(v);
	MapSqlParameterSource map = new MapSqlParameterSource();
	map.addValue("name", s.getName());
	map.addValue("contact", s.getContact());
	map.addValue("email", s.getEmail());
	map.addValue("password", s.getPassword());
	map.addValue("p1", passenc.encode(s.getPassword()));
	map.addValue("authority", "student");
	map.addValue("enabled", "true");

	jdbc.update("insert into employee(name,contact,email,password) "
			+ "values (:name,:contact,:email,:password)", map);
	jdbc.update("insert into users(username,password,enabled) values (:email,:p1,:enabled)", map);
	jdbc.update("insert into authorities(username,authority) values (:email,:authority)", map);
	
}

public Student getEmployeeRecord(String currentUsername) {
	MapSqlParameterSource map = new MapSqlParameterSource();
	map.addValue("email", currentUsername);
	return jdbc.queryForObject("select * from employee where email=:email", map ,new RowMapper<Student>(){

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s =new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setContact(rs.getString("contact"));
			s.setEmail(currentUsername);
			return s;
		}
		
	});
	
	
	
}
	*/
	
	
}
