package com.ourticket.service;

import com.ourticket.model.Notification;
import com.ourticket.model.Ticket;
import com.ourticket.model.Utilisateur;
import com.ourticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
private  final TicketRepository ticketRepository;
private JavaMailSender envoimail ;
private NotificationService notificationService;
@Override
public Ticket creer(Ticket ticket)
{      ticket.setDateCreation(new Date());
        Notification notification = new Notification();
        notification.setMessage("Vous venez de recevoir un nouveau ticket !");
        notification.setUtilisateur(ticket.getFormateur());
        Ticket ticket1 =ticketRepository.save(ticket);
        notification.setTicket(ticket1);
        Notification notification1 = this.notificationService.creer(notification);
        sendEmail(ticket.getFormateur().getEmail(),"Nouveau Ticket!",notification1.getMessage());
        return ticket;
}

@Override
public List<Ticket> lire() {
        return ticketRepository.findAll();
        }

@Override
public Ticket modifier(Long id, Ticket ticket) {
        Optional<Ticket> ticket1 = ticketRepository.findById(id);
        if (ticket1.isPresent()){
                Ticket t = ticket1.get();
        t.setDescription(ticket.getDescription());
        t.setReponse(ticket.getReponse());
        t.setDateCreation(ticket.getDateCreation());
        t.setEtats(ticket.getEtats());
        t.setCategories(ticket.getCategories());
        t.setPriorites(ticket.getPriorites());
        return ticketRepository.save(t);
         }
        else {
                System.out.println("Aucun !! ");
                return null;
                }

        }

@Override
public String supprimer(Long id) {
        ticketRepository.deleteById(id);
        return "Ticket supprimé!";

        }

@Async
public void sendEmail(String to,String subject,String body){
        SimpleMailMessage message =new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("safiatoutandia1@gmail.com");
        this.envoimail.send(message);
}

        }