package com.ourticket.service;

import com.ourticket.model.Etat;
import com.ourticket.model.Utilisateur;
import com.ourticket.repository.EtatRepository;
import com.ourticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtatServiceImpl implements EtatService{

    private  final EtatRepository etatRepository;

    @Override
    public Etat creer(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public List<Etat> lire() {
        return etatRepository.findAll();
    }

    @Override
    public Etat modifier(Long id, Etat etat) {
        Optional<Etat> etat1 = etatRepository.findById(id);
        if (etat1.isPresent()){
            Etat e = etat1.get();
            e.setDescription(etat.getDescription());
            e.setNom(etat.getNom());
            return etatRepository.save(e);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }

    }

    @Override
    public String supprimer(Long id) {
       etatRepository.deleteById(id);
        return "Utilisateur supprimé!";

    }
}
