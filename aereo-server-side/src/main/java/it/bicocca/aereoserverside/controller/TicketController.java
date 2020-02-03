package it.bicocca.aereoserverside.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.bicocca.aereoserverside.entity.Flight;
import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.services.impl.FidelityCardServiceImpl;
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
    @Autowired
    private FidelityCardServiceImpl cardService;

    @CrossOrigin
    @GetMapping("/tickets/{buyerId}")
    public List<Ticket> getTickets(@PathVariable Long buyerId) {
        return ticketsService.getByBuyer(buyerId);
    }
    @CrossOrigin
    @GetMapping("/ticket/{Id}")
    public Ticket getTicket(@PathVariable Long ticketId) {
        return ticketsService.getById(ticketId);
    }

    @CrossOrigin
    @PostMapping("/ticket/buy/{userId}/{flightId}/{points}/{reserved}")
    public Ticket saveTicket(@PathVariable Long userId,
                                     @PathVariable Long flightId,
                                     @PathVariable Long points,
                                     @PathVariable Boolean reserved) {
        User buyer = userService.getById(userId);
        Flight flight = flightService.getById(flightId);
        Ticket ticket = new Ticket(buyer, flight, reserved);

        if (!reserved){
            cardService.updatePoints(cardService.getByCardNumber(buyer.getFidelityCard().getCardNumber()), points);
        }
        flight.setSeatsLeft(flight.getSeatsLeft() - 1);
        return ticketsService.saveTicket(ticket);
    }

    @CrossOrigin
    @GetMapping("delete-ticket/{id}")
    public void delete(@PathVariable Long id) {
        ticketsService.delete(id);
    }
}//end class
