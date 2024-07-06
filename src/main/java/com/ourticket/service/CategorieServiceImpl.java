package com.ourticket.service;
import com.ourticket.model.Categorie;
import com.ourticket.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;

    @Override
    public Categorie creer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> lire() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie modifier(Long id, Categorie categorie) {
        Optional<Categorie> categorie1= categorieRepository.findById(id);
        if (categorie1.isPresent()){
            Categorie c = categorie1.get();
            c.setDescription(categorie.getDescription());
            c.setNom(categorie.getNom());
            return categorieRepository.save(c);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }

    }

    @Override
    public String supprimer(Long id) {
        categorieRepository.deleteById(id);
        return "Catégorie supprimée!";

    }



}
