package com.example.demo;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;



@SpringBootApplication
public class SpringBootDemo01Application {
	
	private static final Logger logger=LoggerFactory.getLogger(SpringBootDemo01Application.class);
	
   @PostConstruct
	public static  void logger() {
		logger.info("info");
		logger.warn("warn");
		logger.debug("debug");
		logger.trace("trace");
	}
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo01Application.class, args);
	
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args ->{
			System.out.println("list beans:"+context.getBeanDefinitionCount());
		};
		
	}
	@Bean
	public ApplicationRunner applicationRunner() {
		return args ->{
			System.out.println("-----");
			System.out.println("Application Runner");
			for (String obj: args.getOptionNames()) {
				System.out.println(obj);
				System.out.println(args.getOptionValues(obj).stream().collect(Collectors.joining(",", "[", "]")));
			}
		};
	}
	
	public ApplicationListener<ApplicationEvent> appListener(){
		final String GE_URL="/ge";
		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(GE_URL))
					System.out.println("visit ge");
			}
		};
	}

}
