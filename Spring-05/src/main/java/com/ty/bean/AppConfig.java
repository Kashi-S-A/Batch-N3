package com.ty.bean;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.ty.bean")
public class AppConfig {

	@Bean
	public List<String> getSubjects() {
		List<String> subjects = Arrays.asList("JAVA", "SPRING", "HIBERNATE");
		return subjects;
	}

	@Bean(value = "college")
	@Scope(value = "prototype")
	public College getCollege() {
		return new College();
	}
}
