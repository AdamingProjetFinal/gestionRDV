package com;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionRdvApplication {
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("Spring boot application runing in utc timezone:"+ new Date());
	}


	public static void main(String[] args) {
		SpringApplication.run(GestionRdvApplication.class, args);
	}

}
