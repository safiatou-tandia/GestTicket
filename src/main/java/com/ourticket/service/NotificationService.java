package com.ourticket.service;

import com.ourticket.model.Notification;
import com.ourticket.model.Utilisateur;

import java.util.List;

public interface NotificationService {

    Notification creer(Notification notification);
    List<Notification> lire();
    List<Notification> lireEnFonctionDe(Utilisateur utilisateur);



}
