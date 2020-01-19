package it.bicocca.aereoserverside.controller;


import it.bicocca.aereoserverside.services.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/test")
    public ResponseEntity getTest() {
        System.out.println("test");
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @GetMapping("/flights")
    public ResponseEntity getFlights() {
        return new ResponseEntity<>(flightService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity getFlightById(@PathVariable Long id) {
        return new ResponseEntity<>(flightService.getById(id), HttpStatus.OK);
    }

    @GetMapping(
            "/flights/{landingLocation}/{departureDay}/{departureLocation}")
    public ResponseEntity getByLandingLocation(
            @PathVariable String landingLocation,
            @PathVariable String departureDay,
            @PathVariable String departureLocation) {
        LocalDate jdepartureDay = LocalDate.of(
                Integer.parseInt(departureDay.substring(5)),
                Integer.parseInt(departureDay.substring(3, 4)),
                Integer.parseInt(departureDay.substring(0, 2)));
        return new ResponseEntity<>(flightService
                                            .getByLandingLocationAndDepartureDayAndDepartureLocation(
                                                    landingLocation,
                                                    jdepartureDay,
                                                    departureLocation),
                                    HttpStatus.OK);
    }
}//end class
