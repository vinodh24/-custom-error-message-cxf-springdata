package com.vinodh.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.vinodh.entity")	
@ComponentScan(basePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.vinodh.repository", entityManagerFactoryRef="jpaEntityManagerFactoryBean")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
