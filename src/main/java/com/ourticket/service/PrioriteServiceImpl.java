package com.ourticket.service;

import com.ourticket.model.Priorite;
import com.ourticket.repository.PrioriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PrioriteServiceImpl implements PrioriteService{
    private  final PrioriteRepository prioriteRepository;
    @Override
    public Priorite creer(Priorite priorite) {
        return prioriteRepository.save(priorite);
    }

    @Override
    public List<Priorite> lire() {
        return prioriteRepository.findAll();
    }

    @Override
    public Priorite modifier(Long id, Priorite priorite) {
        Optional<Priorite> priorite1 = prioriteRepository.findById(id);
        if (priorite1.isPresent()){
            Priorite p = priorite1.get();
            p.setDescription(priorite.getDescription());
            p.setNom(priorite.getNom());
            return prioriteRepository.save(p);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }

    }

    @Override
    public String supprimer(Long id) {
        prioriteRepository.deleteById(id);
        return "Utilisateur supprimé!";

    }

}
