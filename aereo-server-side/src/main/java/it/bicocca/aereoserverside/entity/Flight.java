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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer price;
    private Boolean cancelled;
}//end class
