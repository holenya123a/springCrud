package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.presentacion.Principal;

@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoApplication.class).headless(false)
				.run(args);
		Principal p = context.getBean(Principal.class);

	}

}
