package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository
        extends JpaRepository<Promotion, Long> {}//end interface
