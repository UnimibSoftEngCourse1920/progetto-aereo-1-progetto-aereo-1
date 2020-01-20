package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.Flight;
import it.bicocca.aereoserverside.repository.FlightRepository;
import it.bicocca.aereoserverside.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Flight getById(Long id) {
        return flightRepository.findById(id).get();
    }

    @Override
    public List<Flight> getByLandingLocationAndDepartureDayAndDepartureLocation(
            String landingLocation, LocalDate departureDay,
            String departureLocation) {
        return flightRepository.findByLandingLocationAndDepartureDayGreaterThanEqualAndDepartureLocation(
                landingLocation, departureDay, departureLocation);
    }

    @Override
    public List<Flight> getByDepartureLocationAndDepartureDay(String departureLocation,
                                               LocalDate departureDay) {
        return flightRepository.findByDepartureLocationAndDepartureDay(
                departureLocation, departureDay);
    }
}//end class
