package com.vikas.AirPricing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private String type;  // ADT (Adult), CNN (Child), INF (Infant)
    private int age;      // Required for children and infants
}
