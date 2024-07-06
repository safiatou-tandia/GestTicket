
package com.ourticket.controller;

import com.ourticket.model.Ticket;
import com.ourticket.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){

        return ticketService.creer(ticket);
    }

    @GetMapping("/read")
    public List<Ticket> read(){
        return ticketService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket ticket1 = ticketService.modifier(id, ticket);
       if (ticket1 != null ){
           return ResponseEntity.ok(ticket1);
       }
       else {
           return ResponseEntity.status(NOT_FOUND)
                   .body("Aucun!!");
       }

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        return ticketService.supprimer(id);
    }
}
