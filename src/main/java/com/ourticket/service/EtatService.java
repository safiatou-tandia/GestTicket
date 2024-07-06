package com.ourticket.service;

import com.ourticket.model.Etat;

import java.util.List;

public interface EtatService {
    Etat creer (Etat etat);
    List<Etat> lire();
    Etat modifier (Long id,Etat etat);
    String supprimer(Long id);

}
