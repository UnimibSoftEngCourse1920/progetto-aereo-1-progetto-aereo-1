package it.bicocca.aereoserverside.scheduler;


import it.bicocca.aereoserverside.entity.FidelityCard;
import it.bicocca.aereoserverside.entity.Ticket;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.services.impl.FidelityCardServiceImpl;
import it.bicocca.aereoserverside.services.impl.TicketsServiceImpl;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private FidelityCardServiceImpl cardService;
    @Autowired
    private TicketsServiceImpl ticketsService;


    @Scheduled(cron = "0 0 8 * * ?")
    public void checkFidelity() {
        List<User> users = new ArrayList<>();
        try {
            users = userService.getAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(User user : users) {
            FidelityCard card = user.getFidelityCard();
            if(card != null) {
                if(card
                        .getLastPurchaseDate()
                        .plusYears(2)
                        .isBefore(LocalDate.now())) {
                    cardService.updatePoints(card, 0L);
                    //Here should send a e-mail
                }
            }
            LocalDate departureDate;
            LocalDate today = LocalDate.now();
            for(Ticket ticket : user.getTickets()) {
                departureDate = ticket.getFlight().getDepartureDay();
                if(today.isAfter(departureDate)) {
                    ticketsService.delete(ticket.getId());
                }
                if(today.isAfter(departureDate.minusDays(3))) {
                    //send email
                }
            }
        }
    }
}
