package it.bicocca.aereoserverside.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.services.impl.TicketsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class TicketController {

    @Autowired
    private TicketsServiceImpl ticketsService;

    @GetMapping("/tickets/{buyerId}")
    public List<Ticket> getTickets(@PathVariable Long buyerId) {
        return ticketsService.getByBuyer(buyerId);
    }

    @PostMapping("/tickets/save")
    public ResponseEntity saveTicket(
            @RequestParam(name = "ticket") String ticketStr)
    throws JsonProcessingException {
        Ticket ticket = new ObjectMapper().readValue(ticketStr, Ticket.class); //to be checked
        ticketsService.saveTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}//end class
