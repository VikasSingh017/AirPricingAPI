package com.vikas.AirPricing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingDetailsDto {
    private String totalPrice;
    private String basePrice;
    private String taxes;
    private String currency;
}
