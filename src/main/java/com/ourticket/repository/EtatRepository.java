package com.ourticket.repository;

import com.ourticket.model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat,Long> {
}
