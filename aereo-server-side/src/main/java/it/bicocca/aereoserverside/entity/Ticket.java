package it.bicocca.aereoserverside.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private User buyer;
    @NotNull
    @ManyToOne
    private Flight flight;
    private Boolean reserved;

    public Ticket() {
    }

    public Ticket(@NotNull User buyer, @NotNull Flight flight,
                  Boolean reserved) {
        this.buyer = buyer;
        this.flight = flight;
        this.reserved = reserved;
    }


}//end class
