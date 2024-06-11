package com.mysql_springboot_thymeleaf_t01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mysql_springboot_thymeleaf_t01.controller")
public class MysqlSpringbootThymeleafT01Application {

	public static void main(String[] args) {
		SpringApplication.run(MysqlSpringbootThymeleafT01Application.class, args);
	}

}
