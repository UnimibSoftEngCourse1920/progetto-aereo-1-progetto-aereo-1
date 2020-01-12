package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.FideltyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FideltyCardRepository extends JpaRepository<FideltyCard, Long> {

    FideltyCard findByCardNumber(Long cardNumber);

}//end interface
