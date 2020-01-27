package it.bicocca.aereoserverside.controller;

import it.bicocca.aereoserverside.entity.FidelityCard;
import it.bicocca.aereoserverside.services.impl.FidelityCardServiceImpl;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class FidelityCardController {

    @Autowired
    private FidelityCardServiceImpl cardService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/card/update/{cardId}/{points}")
    public ResponseEntity saveCard(@PathVariable Long points,
                                   @PathVariable Long cardId) {
        cardService.updatePoints(cardService.getByCardNumber(cardId), points);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}//end class
