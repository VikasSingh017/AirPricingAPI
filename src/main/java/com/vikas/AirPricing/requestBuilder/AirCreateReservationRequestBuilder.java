package com.vikas.AirPricing.requestBuilder;

import com.vikas.AirPricing.dto.AirCreateReservationRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AirCreateReservationRequestBuilder {

    public String buildSoapRequest(AirCreateReservationRequestDto request) {
        StringBuilder soapRequest = new StringBuilder();

        soapRequest.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                .append("xmlns:univ=\"http://www.travelport.com/schema/universal_v52_0\" ")
                .append("xmlns:air=\"http://www.travelport.com/schema/air_v52_0\" ")
                .append("xmlns:com=\"http://www.travelport.com/schema/common_v52_0\">")
                .append("<soapenv:Body>")
                .append("<univ:AirCreateReservationReq AuthorizedBy=\"TBO\" TargetBranch=\"P7232098\">")
                .append("<com:BillingPointOfSaleInfo OriginApplication=\"UAPI\"/>")
                .append("<univ:UniversalRecord>"); // ✅ Added Wrapper

        // ✅ Travelers Information
        for (var traveler : request.getTravelers()) {
            soapRequest.append("<com:BookingTraveler TravelerType=\"").append(traveler.getTravelerType()).append("\" Gender=\"").append(traveler.getGender()).append("\">")
                    .append("<com:BookingTravelerName First=\"").append(traveler.getFirstName()).append("\" Last=\"").append(traveler.getLastName()).append("\"/>")
                    .append("<com:PhoneNumber Number=\"").append(traveler.getPhoneNumber()).append("\" Type=\"Mobile\"/>")
                    .append("<com:Email EmailID=\"").append(traveler.getEmail()).append("\"/>")
                    .append("</com:BookingTraveler>");
        }

        // ✅ Flight Segments
        soapRequest.append("<air:AirReservation>"); // ✅ Added Wrapper
        for (var segment : request.getFlightSegments()) {
            soapRequest.append("<air:AirSegment Origin=\"").append(segment.getOrigin()).append("\" ")
                    .append("Destination=\"").append(segment.getDestination()).append("\" ")
                    .append("DepartureTime=\"").append(segment.getDepartureTime()).append("\" ")
                    .append("Carrier=\"").append(segment.getCarrier()).append("\" ")
                    .append("FlightNumber=\"").append(segment.getFlightNumber()).append("\" ")
                    .append("ClassOfService=\"").append(segment.getClassOfService()).append("\"/>");
        }
        soapRequest.append("</air:AirReservation>"); // ✅ Closing Wrapper

        soapRequest.append("</univ:UniversalRecord>") // ✅ Closing Wrapper
                .append("</univ:AirCreateReservationReq>")
                .append("</soapenv:Body>")
                .append("</soapenv:Envelope>");

        return soapRequest.toString();
    }
}
