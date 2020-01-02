package it.bicocca.aereoserverside.controller;


import it.bicocca.aereoserverside.services.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/flights")
    public ResponseEntity getFlights() {
        return new ResponseEntity<>(flightService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity getFlightById(@PathVariable Long id) {
        return new ResponseEntity<>(flightService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/flights/{landingLocation}")
    public ResponseEntity getByLandingLocation(
            @PathVariable String landingLocation) {
        return new ResponseEntity<>(
                flightService.getByLandingLocation(landingLocation),
                HttpStatus.OK);
    }

//    @GetMapping("/flights/{landingLocation}/{departureDay}/{departureHour}")
//    public ResponseEntity getByDepartureLocationAndDateTime(
//            @PathVariable String landingLocation,
//            @PathVariable LocalDate departureDay,
//            @PathVariable LocalTime departureHour) {
//        return new ResponseEntity<>(flightService
//                                            .getByDepartureLocationAndDateTime(
//                                                    landingLocation,
//                                                    departureDay,
//                                                    departureHour),
//                                    HttpStatus.OK);
//    }

}//end class
