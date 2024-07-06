package com.ourticket.service;

import com.ourticket.model.Priorite;

import java.util.List;

public interface PrioriteService {

    Priorite creer(Priorite priorite);
    List<Priorite> lire();
    Priorite modifier(Long id,Priorite priorite);
    String  supprimer(Long id);
}
