package com.vikas.AirPricing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Base64;

@Configuration
public class WebClientConfig {

    private static final String TRAVELPORT_API_URL = "https://apac.universal-api.pp.travelport.com/B2BGateway/connect/uAPI/AirService";
    private static final String TRAVELPORT_USERNAME = "Universal API/uAPI8523180071-c5c2b21b";
    private static final String TRAVELPORT_PASSWORD = "t{4W7A}z%q";

    @Bean
    public WebClient webClient() {
        String authHeader = "Basic " + Base64.getEncoder().encodeToString((TRAVELPORT_USERNAME + ":" + TRAVELPORT_PASSWORD).getBytes());

        return WebClient.builder()
                .baseUrl(TRAVELPORT_API_URL)
                .defaultHeader("Authorization", authHeader)
                .defaultHeader("Content-Type", "text/xml")
                .defaultHeader("Accept", "application/xml")
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(20 * 1024 * 1024))
                        .build())
                .build();
    }
}
