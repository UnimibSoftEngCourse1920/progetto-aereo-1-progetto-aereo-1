package it.bicocca.aereoserverside.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer seatsNumber;
    @NotNull
    private Integer seatsLeft;
    @NotNull
    private LocalDate departureDay;
    @NotNull
    private LocalTime departureHour;
    @NotNull
    private String departureLocation;
    @NotNull
    private String landingLocation;
    @NotNull
    private LocalTime landingHour;
    @NotNull
    private Long price;
    @NotNull
    private Boolean inPromo;

    public Flight() {
    }

    public Flight(@NotNull Integer seatsNumber, @NotNull Integer seatsLeft,
                  @NotNull LocalDate departureDay,
                  @NotNull LocalTime departureHour,
                  @NotNull String departureLocation,
                  @NotNull String landingLocation,
                  @NotNull LocalTime landingHour, @NotNull Long price,
                  @NotNull Boolean inPromo) {
        this.seatsNumber = seatsNumber;
        this.seatsLeft = seatsLeft;
        this.departureDay = departureDay;
        this.departureHour = departureHour;
        this.departureLocation = departureLocation;
        this.landingLocation = landingLocation;
        this.landingHour = landingHour;
        this.price = price;
        this.inPromo = inPromo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Integer getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(Integer seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public LocalDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(LocalDate departureDay) {
        this.departureDay = departureDay;
    }

    public LocalTime getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(LocalTime departureHour) {
        this.departureHour = departureHour;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getLandingLocation() {
        return landingLocation;
    }

    public void setLandingLocation(String landingLocation) {
        this.landingLocation = landingLocation;
    }

    public LocalTime getLandingHour() {
        return landingHour;
    }

    public void setLandingHour(LocalTime landingHour) {
        this.landingHour = landingHour;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getInPromo() {
        return inPromo;
    }

    public void setInPromo(Boolean inPromo) {
        this.inPromo = inPromo;
    }
}//end class
