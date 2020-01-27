package it.bicocca.aereoserverside.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.services.impl.FlightServiceImpl;
import it.bicocca.aereoserverside.services.impl.TicketsServiceImpl;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
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
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/tickets/{buyerId}")

    public List<Ticket> getTickets(@PathVariable Long buyerId) {
        return ticketsService.getByBuyer(buyerId);
    }

    @PostMapping("/ticket/buy/{userId}/{flightId/{reserved}")
    public ResponseEntity saveTicket(@PathVariable Long userId,
                                     @PathVariable Long flightId,
                                     @PathVariable Boolean reserved) {

        Ticket ticket = new Ticket(userService.getById(userId),
                                   flightService.getById(flightId), reserved);
        ticketsService.saveTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}//end class
