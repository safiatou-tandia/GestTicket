package com.ourticket.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Utilisateur utilisateur;




}
