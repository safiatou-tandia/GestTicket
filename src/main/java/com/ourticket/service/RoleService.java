package com.ourticket.service;

import com.ourticket.model.Role;

import java.util.List;

public interface RoleService {
    Role creer(Role role);
    List<Role> lire();
    Role modifier(Long id,Role role);
    String  supprimer(Long id);
}
