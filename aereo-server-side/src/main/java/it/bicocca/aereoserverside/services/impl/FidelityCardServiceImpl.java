package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.FidelityCard;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.repository.FidelityCardRepository;
import it.bicocca.aereoserverside.services.FidelityCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class FidelityCardServiceImpl implements FidelityCardService {

    @Autowired
    private FidelityCardRepository fidelityCardRepository;

    @Override
    public FidelityCard getByCardNumber(Long cardNumber) {
        return fidelityCardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public FidelityCard saveCard() {
        FidelityCard card = new FidelityCard();
        return fidelityCardRepository.save(card);
    }

    @Override
    public FidelityCard saveCard(FidelityCard card) {
        return fidelityCardRepository.save(card);
    }

    @Override
    public FidelityCard updatePoints(FidelityCard card, Long points) {
        card.setPoints(card.getPoints() + points);
        card.setLastPurchaseDate(LocalDate.now());
        return fidelityCardRepository.save(card);
    }
}//end class