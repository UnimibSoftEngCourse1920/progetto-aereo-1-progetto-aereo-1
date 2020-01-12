package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.FidelityCard;
import it.bicocca.aereoserverside.entity.User;

public interface FidelityCardService {

    FidelityCard getByOwner(User ownerId);
    FidelityCard updatePoints(FidelityCard card, Long points);
    FidelityCard getByCardNumber(Long cardNumber);
    FidelityCard saveCard(FidelityCard card);

}//end interface
