package com.brunocarreira.vehicles;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Bruno Carreira
 * 
 * Exercise Part 2
 * Spring Boot Application Context initializer.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Part2App {
	
	public static void main(String[] args){
		new SpringApplicationBuilder(Part1App.class) 
		.sources(Part2App.class)
		.run(args);
	}
}