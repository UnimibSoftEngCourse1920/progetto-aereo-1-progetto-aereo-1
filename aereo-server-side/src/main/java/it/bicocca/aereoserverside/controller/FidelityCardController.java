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
    private UserServiceImpl userService;

    @GetMapping("/card/{ownerId}")
    public ResponseEntity getCard(@PathVariable Long ownerId) {
        return new ResponseEntity<>(
                cardService.getByOwner(userService.getById(ownerId)),
                HttpStatus.OK);
    }

    @PostMapping("/card/update/{cardId}/{points}")
    public ResponseEntity saveCard(@PathVariable Long points,
                                   @PathVariable Long cardId) {
        cardService.updatePoints(cardService.getByCardNumber(cardId), points);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/card/create/{ownerId}")
    public ResponseEntity saveCard(@PathVariable Long ownerId) {
        FidelityCard fidelityCard = new FidelityCard();
        fidelityCard.setOwner(userService.getById(ownerId));
        cardService.saveCard(fidelityCard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}//end class
