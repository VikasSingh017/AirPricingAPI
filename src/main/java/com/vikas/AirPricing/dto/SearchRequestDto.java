package com.vikas.AirPricing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int adults;
    private int children;
    private int infants;

    // ✅ Add these fields at the request level
    private String carrier;
    private String flightNumber;
    private String classOfService;

    private List<SearchLegDto> legs; // Keep legs optional for round trips
}
