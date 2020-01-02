package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> getByLandingLocation(String landingLocation);


//    @Query("select f from flights as f where f.landingLocation = " +
//           ":landingLocation and f.departureDay >= :departureDay and " +
//           "f.departureHour >= :departureHour")
//    List<Flight> getByDepartureLocationAndDateTime(
//            @Param("landingLocation") String landingLocation,
//            @Param("departureDay") LocalDate departureDay,
//            @Param("departureHour") LocalTime departureHour);


}//end interface
