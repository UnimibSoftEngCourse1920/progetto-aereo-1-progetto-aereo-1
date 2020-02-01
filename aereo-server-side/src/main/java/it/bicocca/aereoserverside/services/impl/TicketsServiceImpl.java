package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.repository.TicketRepository;
import it.bicocca.aereoserverside.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketsServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private UserServiceImpl userService;

    @Override
    public List<Ticket> getByBuyer(Long buyerId) {
        User buyer = userService.getById(buyerId);
        return ticketRepository.findByBuyer(buyer);
    }

    @Override
    public Ticket getById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(new Ticket());
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}//end class