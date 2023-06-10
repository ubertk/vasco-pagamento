package com.vascobancopagamento.vascobancopagamentoarti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BoletoConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
