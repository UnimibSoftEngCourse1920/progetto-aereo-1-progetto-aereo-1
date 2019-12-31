package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlightService {
    Flight getById(Long id);

    List<Flight> getAll();

    List<Flight> getByLandingLocation(String landingLocation);

    List<Flight> getByDepartureLocationAndDateTime(String landingLocation,
                                                   LocalDate departureDay,
                                                   LocalTime departureHour);
}//end interface
