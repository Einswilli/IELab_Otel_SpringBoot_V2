package com.ielab.ieotel_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//@ComponentScan("com.mongotest")
//@EnableMongoRepositories("com.mongotest")
@SpringBootApplication
public class IeotelSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IeotelSpringbootApplication.class, args);
	}

}
