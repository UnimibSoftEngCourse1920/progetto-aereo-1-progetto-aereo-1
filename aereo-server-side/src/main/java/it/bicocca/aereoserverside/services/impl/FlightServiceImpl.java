package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.Flight;
import it.bicocca.aereoserverside.exception.NotFoundException;
import it.bicocca.aereoserverside.repository.FlightRepository;
import it.bicocca.aereoserverside.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        return (Flight) flightRepository.findById(id).get();
    }

    @Override
    public List<Flight> getByLandingLocation(String landingLocation) {
        return flightRepository.getByLandingLocation(landingLocation);
    }

//    @Override
//    public List<Flight> getByDepartureLocationAndDateTime(
//            String landingLocation, LocalDate departureDay,
//            LocalTime departureHour) {
//        return flightRepository.getByDepartureLocationAndDateTime(
//                landingLocation, departureDay, departureHour);
//    }

    @Override
    public List<Flight> getByDepartureLocationAndDateTime(
            String landingLocation, LocalDate departureDay,
            LocalTime departureHour) {
        return new ArrayList<Flight>();
    }
}//end class
