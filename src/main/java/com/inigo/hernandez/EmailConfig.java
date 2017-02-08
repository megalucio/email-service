package com.inigo.hernandez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.inigo.hernandez")
@PropertySource("classpath:email.properties")
@Configuration
public class EmailConfig {

	public static void main(String[] args) {
		SpringApplication.run(EmailConfig.class, args);
	}
	
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		// It is required to set the order of this filter to be loaded before
		// springSecurityFilterChain and errorPage filter to be laded at the
		// very beginning of the chain. Otherwise CORS support will be broken
		// and the required headers won't be introduced
		bean.setOrder(Integer.MIN_VALUE);
		return bean;
	}
}
