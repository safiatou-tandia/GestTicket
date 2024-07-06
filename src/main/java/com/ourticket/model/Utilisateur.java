package com.ourticket.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="UTILISATEUR")
@Data
public class Utilisateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 50)
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private Integer telephone;

    @ManyToOne
    @JoinColumn
    private Role role;

}
