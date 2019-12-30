package it.bicocca.aereoserverside.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fidelty_card")
@Data
public class FideltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumber;
    private Long points;
    private LocalDate lastPurchaseDate;

    public FideltyCard() {
        this.points = 0L;
        this.lastPurchaseDate = LocalDate.now();
    }
    public FideltyCard(long points) {
        this.points = points;
        this.lastPurchaseDate = LocalDate.now();
    }
}//end class
