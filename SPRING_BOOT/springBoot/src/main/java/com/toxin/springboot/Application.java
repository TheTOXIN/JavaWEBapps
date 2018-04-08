package com.toxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {
	@PostConstruct
	public void init() {
		System.out.println("-=SPRING BOOT STAR=-");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
