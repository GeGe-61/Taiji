package cn.com.taiji.gege.po;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Enter {
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	
    @Test
	public void userTest() {
		
		User user=(User) context.getBean("user");
		System.out.println(context.getBeanDefinitionCount());
	
		System.out.println(user.getStu().getClass());
		
		System.out.println(user.getUname());
		System.out.println(user.getUage());
		System.out.println(user.getStu().toString());
		
		user.getStu().setStuName("yang");
		System.out.println(user.getStu().toString());

	}
    
	

}
