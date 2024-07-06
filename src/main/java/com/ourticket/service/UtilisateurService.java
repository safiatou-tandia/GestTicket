package com.ourticket.service;

import com.ourticket.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur creer(Utilisateur utilisateur);
    List<Utilisateur> lire();
    Utilisateur modifier(Long id,Utilisateur utilisateur);
    String  supprimer(Long id);

}
