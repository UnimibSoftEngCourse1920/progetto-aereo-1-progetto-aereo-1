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

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getAll();
    }

    /*@GetMapping("/flights")
    public List<Flight> getFlights() {
        List<Flight> flightList = new ArrayList<Flight>();
        flightList.add(new Flight(0L,123, LocalDate.now(), LocalTime.now(),
                                  "milan", LocalDate.now(), LocalTime.now(),
                                  "paris", 300, false));
        return flightList;
    }*/

    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @GetMapping("/flights/{landingLocation}/{departureDay}/" +
                "{departureLocation}")
    public List<Flight> getByLandingLocation(
            @PathVariable String landingLocation,
            @PathVariable String departureDay,
            @PathVariable String departureLocation) {

        LocalDate jdepartureDay = LocalDate.now();
        if(!departureDay.equals("")) {
            jdepartureDay =
                    LocalDate.of(Integer.parseInt(departureDay.substring(5)),
                                 Integer.parseInt(departureDay.substring(3, 4)),
                                 Integer.parseInt(
                                         departureDay.substring(0, 2)));
        }
        // You cannot retrieve a flight without a date - by default is today
        if(!landingLocation.equals("")) {
            return flightService.getByLandingLocationAndDepartureDayAndDepartureLocation(
                    landingLocation, jdepartureDay, departureLocation);
        } else {
            return flightService.getByDepartureLocationAndDepartureDay(
                    departureLocation, jdepartureDay);
        }
    }
}//end class
