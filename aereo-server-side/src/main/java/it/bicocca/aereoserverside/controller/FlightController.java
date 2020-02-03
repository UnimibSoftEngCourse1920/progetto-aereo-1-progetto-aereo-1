package it.bicocca.aereoserverside.controller;


import it.bicocca.aereoserverside.entity.Flight;
import it.bicocca.aereoserverside.services.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @CrossOrigin
    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getAll();
    }

    @CrossOrigin
    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @CrossOrigin
    @GetMapping("/flights/{departureLocation}/{landingLocation}/{departureDay}")
    public List<Flight> getByLandingLocation(
            @PathVariable String departureLocation,
            @PathVariable String landingLocation,
            @PathVariable String departureDay) {

        if(departureLocation.equals("all") && landingLocation.equals("all") && departureDay.equals("any")) {
            return flightService.getAll();
        } else {
            LocalDate jdepartureDay;

            if(!departureDay.equals("any")) {
                jdepartureDay = LocalDate.of(Integer.parseInt(departureDay.substring(5)),
                                             Integer.parseInt(departureDay.substring(3, 4)),
                                             Integer.parseInt(departureDay.substring(0, 2)));
            } else {
                jdepartureDay = LocalDate.now();
            }
            // You cannot retrieve a flight without a date - by default is today
            if(!landingLocation.equals("all")) {
                return flightService.getByLandingLocationAndDepartureDayAndDepartureLocation(
                        landingLocation, jdepartureDay, departureLocation);
            } else {
                return flightService.getByDepartureLocationAndDepartureDay(
                        departureLocation, jdepartureDay);
            }
        }
    }
}//end class
