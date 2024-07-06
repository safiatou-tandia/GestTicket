package com.ourticket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "CATEGORIE")
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    //@OneToOne
    //@JoinColumn(name = "ticketId")
    //private Ticket ticket;

}
