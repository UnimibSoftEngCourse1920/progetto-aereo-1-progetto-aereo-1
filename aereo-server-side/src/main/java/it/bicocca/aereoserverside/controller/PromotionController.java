package it.bicocca.aereoserverside.controller;

import it.bicocca.aereoserverside.entity.Promotion;
import it.bicocca.aereoserverside.services.impl.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class PromotionController {

    @Autowired
    private PromotionServiceImpl promotionService;

    @GetMapping("/promo")
    public List<Promotion> getPromo() {
        return promotionService.getAll();
    }

}//end class
