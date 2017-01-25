package com.inigo.hernandez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.inigo.hernandez")
@PropertySource("classpath:email.properties")
public class MailConfig {

	public static void main(String[] args) {
		SpringApplication.run(MailConfig.class, args);
	}
}
