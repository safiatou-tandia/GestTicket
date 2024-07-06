package com.ourticket.service;

import com.ourticket.model.Role;
import com.ourticket.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Override
    public Role creer(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> lire() {
        return roleRepository.findAll();
    }

    @Override
    public Role modifier(Long id, Role role) {
        Optional<Role> role1 = roleRepository.findById(id);
        if (role1.isPresent()){
            Role r = role1.get();
            r.setDescription(role.getDescription());
            r.setNom(role.getNom());
            return roleRepository.save(r);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }

    }

    @Override
    public String supprimer(Long id) {
        roleRepository.deleteById(id);
        return "Role supprimé!";

    }
}
