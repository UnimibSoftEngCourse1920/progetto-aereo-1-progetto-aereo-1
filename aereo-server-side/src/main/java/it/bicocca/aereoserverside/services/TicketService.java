package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getByBuyer(Long buyerId);

    Ticket saveTicket(Ticket ticket);

}//end interface
