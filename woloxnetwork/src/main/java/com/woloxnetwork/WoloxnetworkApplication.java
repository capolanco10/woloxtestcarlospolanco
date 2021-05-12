package com.woloxnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
@Configuration
@ComponentScan("com.woloxnetwork")
public class WoloxnetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoloxnetworkApplication.class, args);
	}

}
