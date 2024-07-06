package com.ourticket.controller;

import com.ourticket.model.Utilisateur;
import com.ourticket.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

   @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){

       return utilisateurService.creer(utilisateur);
   }

   @GetMapping("/read")
    public List<Utilisateur> read(){
       return utilisateurService.lire();
   }

   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
       Utilisateur user = utilisateurService.modifier(id, utilisateur);
       if (user != null) {
           // Si l'utilisateur est trouvé, renvoyer l'entité utilisateur
           return ResponseEntity.ok(user);
       } else {
           // Si l'utilisateur n'est pas trouvé, renvoyer un message d'erreur
           return ResponseEntity.status(NOT_FOUND)
                   .body("Aucun!!");
       }
   }

   @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
       return utilisateurService.supprimer(id);
   }
}
