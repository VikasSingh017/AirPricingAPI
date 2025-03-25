package com.vikas.AirPricing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLegDto {
    private String origin;
    private String destination;
    private String departureDate;
}
