package com.ebs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebs.beans.Employee;
import com.ebs.beans.Project;
import com.ebs.beans.Salary;

@Component
public class Account {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Project> getAllProjects() {
		return jdbc.query("select * from project", new RowMapper<Project>(){

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				Project p = new Project();
				p.setProj_id(rs.getInt("proj_id"));
				p.setProj_name(rs.getString("proj_name"));
				p.setProj_start_date(rs.getString("proj_start_date"));
				p.setProj_estimated_end_date(rs.getString("proj_estimated_end_date"));
				p.setProj_end_date(rs.getString("proj_end_date"));
				p.setProj_client_name(rs.getString("proj_client_name"));
				p.setBudget(rs.getString("budget"));
				p.setStatus(rs.getString("status"));
				return p;
			}
		});
	}

	public List<Salary> getEmployeeCurrentSalary(){
		return jdbc.query("select * from salary_record", new RowMapper<Salary>(){

			@Override
			public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
				Salary s=new Salary();
				s.setRecord_id(rs.getInt("record_id"));
				s.setEmp_id(rs.getInt("emp_id"));
				s.setSalary(rs.getString("salary"));
				s.setDate(rs.getString("date"));
				return s;
			
				}
		});
	}
	
	
	
	public void addEmployee(Employee e) {
		MapSqlParameterSource map= new MapSqlParameterSource();
		map.addValue("emp_id", e.getEmp_id());
		map.addValue("emp_name",e.getEmp_name());
		map.addValue("emp_address",e.getEmp_address() );
		map.addValue("username",e.getUsername() );
		map.addValue("emp_joindate", e.getEmp_joindate());
		map.addValue("emp_leavedate", e.getEmp_leavedate());
		map.addValue("emp_salary", e.getEmp_salary());
		map.addValue("password",e.getPassword() );
		map.addValue("enabled",e.getEnabled() );
		//map.addValue("enabled",v.getEnabled() );
		//map.addValue("authority",v.getAuthority() );
		map.addValue("emp_id", e.getEmp_id());
		jdbc.update("insert into users(username,password,enabled) values(:username,:password,:enabled)", map);
		jdbc.update("insert into employee(emp_id,emp_name,emp_address,emp_joindate,emp_leavedate,emp_salary,username) values(:emp_id,:emp_name,:emp_address,:emp_joindate,:emp_leavedate,:emp_salary,:username)", map);
	}
	
		public List<Salary> getEmployeeId() {
			return jdbc.query("select emp_id from salary_record", new RowMapper<Salary>(){

				@Override
				public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
					Salary s=new Salary();
					
					s.setEmp_id(rs.getInt("emp_id"));
					return s;
				
					}
			});

		}
	
}
