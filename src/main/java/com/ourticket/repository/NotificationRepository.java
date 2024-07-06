package com.ourticket.repository;

import com.ourticket.model.Notification;
import com.ourticket.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByUtilisateur(Utilisateur utilisateur);
}
