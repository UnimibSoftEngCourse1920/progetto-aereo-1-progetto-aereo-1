package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    Flight getById(Long id);

    List<Flight> getAll();

    List<Flight> getByLandingLocationAndDepartureDayAndDepartureLocation(
            String landingLocation, LocalDate departureDay,
            String departureLocation);

    List<Flight> getByDepartureLocationAndDepartureDay(
            String departureLocation, LocalDate departureDay);
}
