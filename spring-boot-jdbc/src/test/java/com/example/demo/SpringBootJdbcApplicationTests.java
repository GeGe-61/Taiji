package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.JdbcDemoDao;
import com.example.demo.dao.SimpleJdbcCallDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {
	@Autowired
	JdbcDemoDao jdbcDemoDao;
	@Autowired
	SimpleJdbcCallDao simpleJdbcCallDao;

	@Test
	public void contextLoads() {
//		User user=new User();
//		user.setUname("cen");
//		user.setUpass("1234");
//		System.out.println(jdbcDemoDao.nameParameter(user));
//		int [] ids=new int[]{1,2};
//		String [] upass=new String[] {"ge","cen"};
//		jdbcDemoDao.batchUpdate(ids, upass);
	
//		System.out.println(	jdbcDemoDao.nameParameter2("ge", "ge"));
		jdbcDemoDao.namePGetUser("ge", "ge");
//		jdbcDemoDao.getCount();
//		jdbcDemoDao.getUserById();
//		jdbcDemoDao.getUser(3);
//		jdbcDemoDao.updatePassword("1234",2);

//		jdbcDemoDao.simple("61", "61");
		
//		jdbcDemoDao.deleUser(3);
//		System.out.println(jdbcDemoDao.nameParameter("ge"));
		
		System.out.println(simpleJdbcCallDao.readUser(1));
	}

}
