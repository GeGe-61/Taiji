package cn.com.taiji.gege.config;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.gege.po.Student;

@RunWith(SpringRunner.class)
@ContextConfiguration()
public class ConfigTest {
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigDemo.class);
	
	@Test
	public void configTest() {
	Student student=(Student) context.getBean("stu");
	System.out.println(student.getStuName());
	System.out.println(context.getBean("dataSource").getClass());
	context.registerShutdownHook();
	}

	
}
