package com.example.demo.dao;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import com.example.demo.po.User;

@Repository
public class JdbcDemoDao {
//	@Autowired
//	private ApplicationContext applicationContext;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	//jdbcTemplate
	@Test
	public void getCount() {
		
		System.out.println(this.jdbcTemplate.queryForObject("select count(*) from tuser",Integer.class));
		
	}
	
	public void getUserById() {
		System.out.println(this.jdbcTemplate.queryForObject("select uname from tuser where tuid= ?", String.class,"1"));
	}
	//rowMapper
	public void getUser(int tuid) {
		
		User user=this.jdbcTemplate.queryForObject("select * from tuser where tuid=?", new Object[] {tuid},
			getRowMap());
		System.out.println(user.toString());
		 
	}
	
	public void deleUser(int tuid) {
		this.jdbcTemplate.update("delete from tuser where tuid=?",tuid);
	}
	
	public void updatePassword(String upass,int tuid) {
		this.jdbcTemplate.update("update tuser set upass=? where tuid=?",upass,tuid);
	}

	public void insertUser(User user) {
		this.jdbcTemplate.update("insert into tuser(uname,upass) values(?,?)",user);
		
	}
	
	
	//nameParameter
	public int nameParameter(User user) {
		String sql="select count(*) from tuser where upass=:upass and uname=:uname";
		SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(user);
		return this.namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource,Integer.class);
	}
	public int nameParameter2(String uname,String upass) {
		String sql="select count(*) from tuser where upass=:upass and uname=:uname";
		Map<String, Object> parameters=new HashMap<>();
		parameters.put("uname", uname);
		parameters.put("upass", upass);
		
		return this.namedParameterJdbcTemplate.queryForObject(sql, parameters,Integer.class);
	}
	
	public void namePGetUser(String uname,String upass) {
		String sqlString="select * from tuser where upass=:upass and uname=:uname";
		Map<String, Object> parameters=new HashMap<>();
		parameters.put("uname", uname);
		parameters.put("upass", upass);
		User user=this.namedParameterJdbcTemplate.queryForObject(sqlString, parameters, getRowMap());
		System.out.println(user.toString());
		
		
	}
	
	
	//simple
	public void simple(String uname,String upass) {
		SimpleJdbcInsert simpleJdbcInsert=new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName("tuser").usingColumns("uname","upass").usingGeneratedKeyColumns("tuid");
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("uname", uname);
		parameters.put("upass", upass);
		simpleJdbcInsert.execute(parameters);
	}
	
	//batch批量处理
	public void batchDele(int [] ids) {
		jdbcTemplate.batchUpdate("delete from sc where scid=?",new BatchPreparedStatementSetter() {
		
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				System.out.println("ok");
				ps.setInt(1, ids[i]);
				ps.execute();
				
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return ids.length;
			}
		
		});
		
	}
	
	public void batchUpdate(int [] ids,String [] upass) {
		jdbcTemplate.batchUpdate("update tuser set upass=? where tuid=?",new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(2,ids[i]);
				ps.setString(1, upass[i]);
				ps.execute();
				
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return ids.length;
			}
		});
		
	}
	
	
	//user工具Mapper
	private RowMapper<User> getRowMap() {
		return 
		new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setTuid(Integer.parseInt(rs.getString(++rowNum)));
				user.setUname(rs.getString(++rowNum));
				user.setUpass(rs.getString(++rowNum));
				user.setUtime(rs.getString(++rowNum));
				return user;
			}
			
			
		};
	}
	

}
