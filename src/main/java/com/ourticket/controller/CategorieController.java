package com.ourticket.controller;

import com.ourticket.model.Categorie;
import com.ourticket.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/categorie")
@AllArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;

    @PostMapping("/create")
    public Categorie create(@RequestBody Categorie categorie){

        return categorieService.creer(categorie);
    }

    @GetMapping("/read")
    public List<Categorie> read(){
        return categorieService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Categorie categorie) {
        Categorie categorie1 = categorieService.modifier(id, categorie);
        if (categorie1 != null ){
            return ResponseEntity.ok(categorie1);
        }
        else {
            return ResponseEntity.status(NOT_FOUND)
                    .body("Aucun!!");
        }

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        return categorieService.supprimer(id);
    }

}

