package cn.com.taiji.gege.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.gege.po.Student;

@Configuration
public class ConfigDemo implements LifeBean{

	@Bean("stu")
	public Student Student() {
		Student student=new Student();
		student.setStuName("ge");
		return student;
		}

	@Bean(destroyMethod="destroy")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("app");
		ds.setPassword("app");
		ds.setUrl("jdbc:mysql://localhost:3306/app?useUnicode=true&characterEncoding=utf-8");
		return ds;
	}

	@Override
	public void init() {
		System.out.println("init");
		
	}

	@Override
	public void destroy() {
		System.out.println("stop");
		
	}
}
