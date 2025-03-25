package com.vikas.AirPricing.service;

import com.vikas.AirPricing.dto.SearchRequestDto;
import com.vikas.AirPricing.requestBuilder.AirPriceRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class AirPriceService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private AirPriceRequestBuilder requestBuilder;

    @Async
    public CompletableFuture<String> getAirPriceResponseXml(SearchRequestDto searchRequest) {
        String soapRequest = requestBuilder.buildSoapRequest(searchRequest);

        return webClient.post()
                .bodyValue(soapRequest)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();
    }

}
