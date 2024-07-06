package com.ourticket.controller;

import com.ourticket.model.Priorite;
import com.ourticket.service.PrioriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/priorite")
@AllArgsConstructor
public class PrioriteController {
    private final PrioriteService prioriteService;

    @PostMapping("/create")
    public Priorite create(@RequestBody Priorite priorite){

        return prioriteService.creer(priorite);
    }

    @GetMapping("/read")
    public List<Priorite> read(){
        return prioriteService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Priorite priorite) {
        Priorite priorite1 = prioriteService.modifier(id, priorite);
        if (priorite1 != null) {
            return ResponseEntity.ok(priorite1);
        } else {
            return ResponseEntity.status(NOT_FOUND)
                    .body("Aucun!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return prioriteService.supprimer(id);
    }
}
