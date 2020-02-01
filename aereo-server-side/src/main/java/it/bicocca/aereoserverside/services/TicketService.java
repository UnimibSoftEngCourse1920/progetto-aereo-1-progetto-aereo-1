package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getByBuyer(Long buyerId);
    Ticket getById(Long ticketId);
    Ticket saveTicket(Ticket ticket);
    void delete(Long id);

}//end interface
