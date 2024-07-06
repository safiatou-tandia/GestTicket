package com.ourticket.service;

import com.ourticket.model.Utilisateur;
import com.ourticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    private  final UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        utilisateur.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> lire() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifier(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateur1 = utilisateurRepository.findById(id);
        if (utilisateur1.isPresent()){
            Utilisateur u = utilisateur1.get();
            u.setRole(utilisateur.getRole());
            u.setNom(utilisateur.getNom());
            u.setPrenom(utilisateur.getPrenom());
            u.setEmail(utilisateur.getEmail());
            u.setMdp(utilisateur.getMdp());
            u.setTelephone(utilisateur.getTelephone());
            return utilisateurRepository.save(u);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }

    }

    @Override
    public String supprimer(Long id) {
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimé!";

    }
}
