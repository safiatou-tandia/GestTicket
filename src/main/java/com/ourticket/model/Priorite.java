package com.ourticket.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Priorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    //@ManyToOne
    //@JoinColumn(name = "ticketId")
    //private Ticket ticket;

}

