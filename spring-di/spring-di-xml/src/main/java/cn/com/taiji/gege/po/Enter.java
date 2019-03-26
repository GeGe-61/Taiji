package cn.com.taiji.gege.po;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Enter {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	
    @Test
	public void userTest() {
		Student student=(Student) context.getBean("student1");
	
 	    System.out.println(student.getStuName());
	    System.out.println(student.getClass());
		
	    ((AbstractApplicationContext) context).registerShutdownHook();
	}
    
	

}
