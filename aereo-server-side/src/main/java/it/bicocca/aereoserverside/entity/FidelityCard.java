package it.bicocca.aereoserverside.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fidelity_card")
@Data
public class FidelityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumber;
    private Long points;
    private LocalDate lastPurchaseDate;
    @OneToOne
    private User owner;

    public FidelityCard() {
        this.points = 0L;
        this.lastPurchaseDate = LocalDate.now();
    }

    public FidelityCard(long points) {
        this.points = points;
        this.lastPurchaseDate = LocalDate.now();
    }
}//end class
