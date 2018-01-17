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
	public void addProject(Project p) {
		MapSqlParameterSource map= new MapSqlParameterSource();
		map.addValue("proj_name",p.getProj_name());
		map.addValue("proj_start_date",p.getProj_start_date() );
		map.addValue("proj_estimated_end_date",p.getProj_estimated_end_date() );
		map.addValue("proj_end_date",p.getProj_end_date() );
		map.addValue("proj_client_name", p.getProj_client_name());
		map.addValue("budget", p.getBudget());
		map.addValue("status",p.getStatus() );
		map.addValue("proj_id", p.getProj_id());
			jdbc.update("insert into project(proj_id,proj_name,proj_start_date,proj_estimated_end_date,proj_end_date,proj_client_name,budget,status) values(:proj_id,:proj_name,:proj_start_date,:proj_estimated_end_date,:proj_end_date,:proj_client_name,:budget,:status)", map);
	}
}
