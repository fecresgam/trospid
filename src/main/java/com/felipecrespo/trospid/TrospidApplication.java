package com.felipecrespo.trospid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrospidApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrospidApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		//TODO: Added for cucumber example. It's really necessary?
		return new RestTemplate();
	}
}
