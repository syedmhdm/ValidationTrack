package com.example.ValidationTrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ValidationTrack.model.DBcolumns;

@RestController
@RequestMapping("vt")
public class Controller {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("test")
	String test() {

		return "our api is working";
	}
	
	@GetMapping("alldata")
	List<DBcolumns> alldata() {
		
		RowMapper<DBcolumns> rm = new BeanPropertyRowMapper<DBcolumns>(DBcolumns.class);
		
		String sql = "select * from vt_table";
		
		List<DBcolumns> alldata = jdbcTemplate.query(sql, rm);
		
		return alldata;
	}

}
