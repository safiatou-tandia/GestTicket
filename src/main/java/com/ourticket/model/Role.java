package com.ourticket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;
        private String description;



    }

