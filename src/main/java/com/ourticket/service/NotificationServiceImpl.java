package com.ourticket.service;

import com.ourticket.model.Notification;
import com.ourticket.model.Utilisateur;
import com.ourticket.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;


    @Override
    public Notification creer(Notification notification) {
        return this.notificationRepository.save(notification);
    }

    @Override
    public List<Notification> lire() {
        return this.notificationRepository.findAll();
    }

    @Override
    public List<Notification> lireEnFonctionDe(Utilisateur utilisateur) {
        return this.notificationRepository.findAllByUtilisateur(utilisateur);
    }
}
