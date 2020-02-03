package it.bicocca.aereoserverside.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fidelity_card")
public class FidelityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumber;
    private Long points;
    private LocalDate lastPurchaseDate;

    public FidelityCard() {
        this.points = 0L;
        this.lastPurchaseDate = LocalDate.now();
    }

    public FidelityCard(long points) {
        this.points = points;
        this.lastPurchaseDate = LocalDate.now();
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public LocalDate getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }
}//end class
