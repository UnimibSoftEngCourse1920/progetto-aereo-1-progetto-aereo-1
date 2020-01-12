package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.FidelityCard;
import it.bicocca.aereoserverside.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidelityCardRepository extends JpaRepository<FidelityCard, Long> {

    FidelityCard findByCardNumber(Long cardNumber);
    FidelityCard findByOwner(User owner);

}//end interface