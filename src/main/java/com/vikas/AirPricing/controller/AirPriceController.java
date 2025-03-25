package com.vikas.AirPricing.controller;

import com.vikas.AirPricing.dto.SearchRequestDto;
import com.vikas.AirPricing.service.AirPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/airprice")
@CrossOrigin("*") // Allows cross-origin requests
public class AirPriceController {

    @Autowired
    private AirPriceService airPriceService;

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    public CompletableFuture<ResponseEntity<String>> getAirPrice(@RequestBody SearchRequestDto searchRequest) {
        return airPriceService.getAirPriceResponseXml(searchRequest)
                .thenApply(response -> ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(response));
    }

}
