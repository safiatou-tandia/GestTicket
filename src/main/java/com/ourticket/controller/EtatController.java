package com.ourticket.controller;

import com.ourticket.model.Etat;
import com.ourticket.service.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/etat")
@AllArgsConstructor

public class EtatController {
    private final EtatService etatService;

    @PostMapping("/create")
    public Etat create(@RequestBody Etat etat){

        return etatService.creer(etat);
    }

    @GetMapping("/read")
    public List<Etat> read(){
        return etatService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Etat etat) {
        Etat etat1 = etatService.modifier(id, etat);
        if (etat1 != null) {
            return ResponseEntity.ok(etat1);
        } else {
            return ResponseEntity.status(NOT_FOUND)
                    .body("Aucun!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return etatService.supprimer(id);
    }
}
