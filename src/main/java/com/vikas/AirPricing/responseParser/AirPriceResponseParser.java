//package com.vikas.AirPricing.responseParser;
//
//import com.vikas.AirPricing.dto.SearchRequestDto;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AirPriceResponseParser {
//
////    public String generateSoapResponse(String apiResponse, SearchRequestDto request) {
////        return "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\">"
////                + "<SOAP:Body>"
////                + "<universal:AirCreateReservationRsp TraceId=\"PP_1G_001\" TransactionId=\"ABC123\" ResponseTime=\"1000\" xmlns:universal=\"http://www.travelport.com/schema/universal_v52_0\">"
////                + "<universal:UniversalRecord LocatorCode=\"1LAM4J\" Version=\"0\" Status=\"Active\">"
////                + generateTravelerInfo(request)
////                + generateFlightSegments(request)
////                + generatePricingInfo()
////                + generateAgencyInfo()
////                + "</universal:UniversalRecord>"
////                + "</universal:AirCreateReservationRsp>"
////                + "</SOAP:Body>"
////                + "</SOAP:Envelope>";
////    }
//
//    private String generateTravelerInfo(SearchRequestDto request) {
//        return "<common_v52_0:BookingTraveler Key=\"123\" TravelerType=\"ADT\" Gender=\"M\">"
//                + "<common_v52_0:BookingTravelerName Prefix=\"MR\" First=\"John\" Last=\"Doe\"/>"
//                + "<common_v52_0:PhoneNumber Type=\"Mobile\" Location=\"DEL\" Number=\"1234567890\"/>"
//                + "<common_v52_0:Email EmailID=\"john.doe@example.com\"/>"
//                + "</common_v52_0:BookingTraveler>";
//    }
//
////    private String generateFlightSegments(SearchRequestDto request) {
////        StringBuilder flightSegments = new StringBuilder();
////        int groupNumber = 0;
////
////        for (var leg : request.getLegs()) {
////            flightSegments.append("<air:AirSegment Key=\"SEG" + groupNumber + "\" Group=\"" + groupNumber + "\" Carrier=\"EK\" FlightNumber=\"123\" Origin=\"")
////                    .append(leg.getOrigin())
////                    .append("\" Destination=\"")
////                    .append(leg.getDestination())
////                    .append("\" DepartureTime=\"")
////                    .append(leg.getDepartureDate())
////                    .append("\" ArrivalTime=\"2025-06-01T10:00:00\" TravelTime=\"180\" Distance=\"1022\" CabinClass=\"Economy\" ETicketability=\"Yes\" Equipment=\"320\" Status=\"HK\"/>");
////            groupNumber++;  // Increments for each flight leg
////        }
////
////        return flightSegments.toString();
////    }
//
//
//    private String generateFlightSegments(SearchRequestDto request) {
//        StringBuilder flightSegments = new StringBuilder();
//        String[] fixedKeys = {
//                "OW+jzQ+pWDKAPKV7IAAAAA==",  // DEL → ALA
//                "OW+jzQ+pWDKARKV7IAAAAA==",  // ALA → DXB
//                "OW+jzQ+pWDKATKV7IAAAAA==",  // DXB → ALA
//                "OW+jzQ+pWDKAVKV7IAAAAA=="   // ALA → DEL
//        };
//
//        int index = 0;
//        for (var leg : request.getLegs()) {
//            flightSegments.append("<air:AirSegment Key=\"")
//                    .append(fixedKeys[index]) // ✅ Use predefined key
//                    .append("\" Group=\"" + index + "\" Carrier=\"KC\" FlightNumber=\"964\" Origin=\"")
//                    .append(leg.getOrigin())
//                    .append("\" Destination=\"")
//                    .append(leg.getDestination())
//                    .append("\" DepartureTime=\"")
//                    .append(leg.getDepartureDate())
//                    .append("\" ArrivalTime=\"2025-06-01T10:00:00\" TravelTime=\"180\" Distance=\"1022\" CabinClass=\"Economy\" ETicketability=\"Yes\" Equipment=\"320\" Status=\"HK\"/>");
//            index++;
//            if (index >= fixedKeys.length) break; // Prevent array index out of bounds
//        }
//
//        return flightSegments.toString();
//    }
//
//
//
//    private String generatePricingInfo() {
//        return "<air:AirPricingInfo Key=\"PRICING1\" TotalPrice=\"INR86639\" BasePrice=\"INR68500\" Taxes=\"INR18139\">"
//                + "<air:PassengerType Code=\"ADT\"/>"
//                + "<air:FareInfo FareBasis=\"HSF\" PassengerTypeCode=\"ADT\" Origin=\"DEL\" Destination=\"DXB\">"
//                + "<common_v52_0:Endorsement Value=\"NONREFUNDABLE\"/>"
//                + "<air:BaggageAllowance><air:NumberOfPieces>1</air:NumberOfPieces></air:BaggageAllowance>"
//                + "</air:FareInfo>"
//                + "</air:AirPricingInfo>";
//    }
//
//    private String generateAgencyInfo() {
//        return "<common_v52_0:AgencyInfo>"
//                + "<common_v52_0:AgentAction ActionType=\"Created\" AgentCode=\"APIUser\" BranchCode=\"P7184975\" EventTime=\"2025-06-01T12:00:00\"/>"
//                + "</common_v52_0:AgencyInfo>";
//    }
//}
