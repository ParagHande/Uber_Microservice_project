package com.example.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UberDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberDriverApplication.class, args);
	}

}
