package com.ourticket.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    //@OneToOne
    //@JoinColumn(name = "ticketId")
    //private Ticket ticket;
}
