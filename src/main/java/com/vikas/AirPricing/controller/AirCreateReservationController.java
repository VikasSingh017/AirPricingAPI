package com.vikas.AirPricing.controller;

import com.vikas.AirPricing.dto.AirCreateReservationRequestDto;
import com.vikas.AirPricing.service.AirCreateReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class AirCreateReservationController {

    @Autowired
    private AirCreateReservationService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    public CompletableFuture<ResponseEntity<String>> createReservation(@RequestBody AirCreateReservationRequestDto requestDto) {
        return service.createReservation(requestDto)
                .thenApply(response -> ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(response));
    }
}
