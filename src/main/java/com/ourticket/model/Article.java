package com.ourticket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Table(name = "ARTICLE")
@Data
public class Article {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 50)
    private String titre;
    @Column(length = 2000)
    private String contenu;
    private Date dateCreation;


}
