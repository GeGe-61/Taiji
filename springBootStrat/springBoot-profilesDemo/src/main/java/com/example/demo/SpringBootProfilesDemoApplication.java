package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.MessageService;

@SpringBootApplication
public class SpringBootProfilesDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesDemoApplication.class, args);
	}
	@Autowired
	private MessageService helloWorldService;

	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getMessage());
	}

}
