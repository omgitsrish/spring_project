package com.ebs.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebs.beans.Project;

@Component
public class AccountAli {
	private NamedParameterJdbcTemplate jdbc;
	private static int count=1;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc= new NamedParameterJdbcTemplate(dataSource);
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
		map.addValue("proj_id", count++);
			jdbc.update("insert into project(proj_id,proj_name,proj_start_date,proj_estimated_end_date,proj_end_date,proj_client_name,budget,status) values(:proj_id,:proj_name,:proj_start_date,:proj_estimated_end_date,:proj_end_date,:proj_client_name,:budget,:status)", map);
	}

	
}
