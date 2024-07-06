package com.ourticket.controller;

import com.ourticket.model.Role;
import com.ourticket.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/create")
    public Role create( Role role){

        return roleService.creer(role);
    }

    @GetMapping("/read")
    public List<Role> read(){
        return roleService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Role role) {
        Role role1 = roleService.modifier(id, role);
        if (role1 != null) {
            return ResponseEntity.ok(role1);
        } else {
            return ResponseEntity.status(NOT_FOUND)
                    .body("Aucun!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return roleService.supprimer(id);
    }
}


