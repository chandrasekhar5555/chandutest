package com.example.SreverEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SreverEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreverEurekaApplication.class, args);
	}

}

