package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByLandingLocationAndDepartureDayGreaterThanEqualAndDepartureLocation(
            String landingLocation, LocalDate departureDay,
            String departureLocation);

    List<Flight> findByDepartureLocationAndDepartureDay(
            String departureLocation, LocalDate departureDay);

}//end interface
