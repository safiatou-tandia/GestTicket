package com.ourticket.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name="TICKET")
@Data
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 50)
    private String description;
    private Date dateCreation;
    @Column(length = 2000)
    private String reponse;

    @ManyToOne
    private Utilisateur Apprenant;

    @ManyToOne
    private Utilisateur Formateur;

    @ManyToOne
    private Categorie categories;

    @ManyToOne
    private Etat etats;

    @ManyToOne
    private Priorite priorites;
}
