package com.banamex.ibm.applyforacreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplyForACreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplyForACreditCardApplication.class, args);
	}

}
