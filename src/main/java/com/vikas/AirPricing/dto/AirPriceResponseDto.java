package com.vikas.AirPricing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirPriceResponseDto {
    private String traceId;
    private List<FlightSegmentDto> flightSegments;
    private PricingDetailsDto pricingDetails;
}
