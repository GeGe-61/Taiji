package com.example.demo.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;


import com.example.demo.po.User;


@Component
public class SimpleJdbcCallDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//不能直接autowired
	private SimpleJdbcCall simpleJdbcCall;
	@Autowired
	private DataSource dataSource;
	
	public User readUser(int tuid) {
		//得用datasource
		simpleJdbcCall=new SimpleJdbcCall(dataSource);
		
		simpleJdbcCall.withProcedureName("read_user");
		
		SqlParameterSource source=new MapSqlParameterSource().addValue("read_id",tuid);
		
		Map out=simpleJdbcCall.execute(tuid);
		User user=new User();
		user.setTuid((Integer)out.get("out_tuid"));
		user.setUname((String)out.get("out_uname"));
		user.setUpass((String)out.get("out_upass"));
		user.setUtime((String)out.get("out_utime"));
		return user;
		
	}

}
