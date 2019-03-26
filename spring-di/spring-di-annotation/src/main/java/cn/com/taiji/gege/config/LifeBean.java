package cn.com.taiji.gege.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public interface LifeBean {
	
	
		@PostConstruct
		public void init();
		
		@PreDestroy
		public void destroy();
	

}
