package com.vikas.AirPricing.requestBuilder;

import com.vikas.AirPricing.dto.SearchRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AirPriceRequestBuilder {

    public String buildSoapRequest(SearchRequestDto searchRequest) {
        StringBuilder soapRequest = new StringBuilder();

        soapRequest.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                .append("xmlns:air=\"http://www.travelport.com/schema/air_v52_0\" ")
                .append("xmlns:com=\"http://www.travelport.com/schema/common_v52_0\">")
                .append("<soapenv:Body>")
                .append("<air:AirPriceReq AuthorizedBy=\"APIUser\" TargetBranch=\"P7232098\" TraceId=\"a0a168a8-1ad3-44d5-b70b-1ccec46b81e8\">")
                .append("<com:BillingPointOfSaleInfo OriginApplication=\"UAPI\" />");

        // ✅ Add Flight Segment
        soapRequest.append("<air:AirItinerary>")
                .append(buildFlightSegment(searchRequest, 0))
                .append("</air:AirItinerary>");

        // ✅ Add AirPricingModifiers (This is the correct location for AirPricingInfo)
        soapRequest.append("<air:AirPricingModifiers ETicketability=\"Yes\" FaresIndicator=\"AllFares\" />");

        // ✅ Add Passenger Information
        soapRequest.append(buildPassengerSegment(searchRequest));

        soapRequest.append("</air:AirPriceReq>")
                .append("</soapenv:Body>")
                .append("</soapenv:Envelope>");

        return soapRequest.toString();
    }


    // ✅ Build Flight Segment with Dynamic FareBasisCode
    private String buildFlightSegment(SearchRequestDto searchRequest, int groupNumber) {
        return "<air:AirSegment Group=\"" + groupNumber + "\" " +
                "ProviderCode=\"1G\" " +
                "Origin=\"" + searchRequest.getOrigin() + "\" " +
                "Destination=\"" + searchRequest.getDestination() + "\" " +
                "DepartureTime=\"" + searchRequest.getDepartureDate() + "\" " +
                "Carrier=\"" + searchRequest.getCarrier() + "\" " +
                "FlightNumber=\"" + searchRequest.getFlightNumber() + "\" " +
                "ClassOfService=\"" + searchRequest.getClassOfService() + "\" " +
                "ETicketability=\"Yes\" " +
                "FareBasisCode=\"" + generateFareBasisCode(searchRequest) + "\" />";  // ✅ Dynamic FareBasisCode
    }

    // ✅ Build Passenger Details
    private String buildPassengerSegment(SearchRequestDto searchRequest) {
        StringBuilder passengerSegment = new StringBuilder();

        // Add Adults
        for (int i = 0; i < searchRequest.getAdults(); i++) {
            passengerSegment.append("<com:SearchPassenger Code=\"ADT\" BookingTravelerRef=\"PAX" + (i + 1) + "\" />");
        }

        // Add Children
        for (int i = 0; i < searchRequest.getChildren(); i++) {
            passengerSegment.append("<com:SearchPassenger Code=\"CNN\" Age=\"10\" BookingTravelerRef=\"PAX" + (i + 1) + "\" />");
        }

        // Add Infants
        for (int i = 0; i < searchRequest.getInfants(); i++) {
            passengerSegment.append("<com:SearchPassenger Code=\"INF\" Age=\"1\" BookingTravelerRef=\"PAX" + (i + 1) + "\" />");
        }

        return passengerSegment.toString();
    }

    // ✅ Generate FareBasisCode Dynamically
    private String generateFareBasisCode(SearchRequestDto searchRequest) {
        return searchRequest.getCarrier() + searchRequest.getClassOfService() + "123";
    }
}
