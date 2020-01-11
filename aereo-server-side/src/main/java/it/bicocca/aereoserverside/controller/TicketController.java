package it.bicocca.aereoserverside.controller;

import it.bicocca.aereoserverside.services.impl.TicketsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TicketController {

    @Autowired
    private TicketsServiceImpl ticketsService;

    @PostMapping("/tickets/{buyerId}")
    public ResponseEntity getTickets(@PathVariable Long buyerId) {
        return new ResponseEntity<>(ticketsService.getByBuyer(buyerId),
                                    HttpStatus.OK);
    }
}//end class
