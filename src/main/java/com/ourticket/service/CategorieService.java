package com.ourticket.service;

import com.ourticket.model.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie creer(Categorie categorie);
    List<Categorie> lire();
    Categorie modifier(Long id,Categorie categorie);
    String  supprimer(Long id);
}
