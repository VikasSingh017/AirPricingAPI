package com.vikas.AirPricing.service;

import com.vikas.AirPricing.dto.AirCreateReservationRequestDto;
import com.vikas.AirPricing.requestBuilder.AirCreateReservationRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.concurrent.CompletableFuture;

@Service
public class AirCreateReservationService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private AirCreateReservationRequestBuilder requestBuilder;

    @Async
    public CompletableFuture<String> createReservation(AirCreateReservationRequestDto requestDto) {
        String soapRequest = requestBuilder.buildSoapRequest(requestDto);
        System.out.println("🟢 Sending SOAP Request:\n" + soapRequest);

        return webClient.post()
                .uri("https://apac.universal-api.pp.travelport.com/B2BGateway/connect/uAPI/AirService")
                .header("Content-Type", "text/xml")
                .bodyValue(soapRequest)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> System.out.println("🔵 Received Response:\n" + response))
                .doOnError(error -> System.err.println("❌ Error: " + error.getMessage()))
                .toFuture();
    }
}
