package com.ourticket.service;

import com.ourticket.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket creer(Ticket ticket);
    List<Ticket> lire();
    Ticket modifier(Long id,Ticket ticket);
    String  supprimer(Long id);

}
