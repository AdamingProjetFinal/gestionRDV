package com;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.entities.Medecin;
import com.service.MedecinService;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionRdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRdvApplication.class, args);
	}

}
