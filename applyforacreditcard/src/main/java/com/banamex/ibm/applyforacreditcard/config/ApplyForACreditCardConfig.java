package com.banamex.ibm.applyforacreditcard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplyForACreditCardConfig {

    @Bean
    public RestTemplate getRestRestTemplate() {
        return new RestTemplate();
    }
}
