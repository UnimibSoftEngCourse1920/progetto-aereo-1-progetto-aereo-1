package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.Promotion;
import it.bicocca.aereoserverside.repository.PromotionRepository;
import it.bicocca.aereoserverside.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromoService {

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getAll() {
        return promotionRepository.findAll();
    }
}//end class
