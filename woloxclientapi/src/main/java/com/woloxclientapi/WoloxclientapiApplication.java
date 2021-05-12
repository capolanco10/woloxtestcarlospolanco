package com.woloxclientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.woloxclientapi"})
public class WoloxclientapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoloxclientapiApplication.class, args);
	}

}
