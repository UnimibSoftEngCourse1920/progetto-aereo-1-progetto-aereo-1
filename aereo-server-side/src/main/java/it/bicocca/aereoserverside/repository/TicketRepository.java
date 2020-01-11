package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByBuyer(@NotNull User buyer);

}//end interface
