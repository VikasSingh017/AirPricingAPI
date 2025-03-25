package com.vikas.AirPricing.dto;

import lombok.Data;
import java.util.List;

@Data
public class AirCreateReservationRequestDto {
    private List<TravelerDto> travelers;
    private List<FlightSegmentDto> flightSegments;
}
