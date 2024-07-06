package com.ourticket.Conf;

import com.ourticket.model.Role;
import com.ourticket.model.Utilisateur;
import com.ourticket.repository.RoleRepository;
import com.ourticket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UtilisateurRepository utilisateurRepository;
    RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
        if (utilisateur == null) throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        Optional<Role> roleExist = roleRepository.findById(utilisateur.getRole().getId());
        Role role = new Role();

        if (roleExist.isPresent()){
            role = roleExist.get();
        }

        return User.
                withUsername(utilisateur.getEmail()).
                password(utilisateur.getMdp()).
                roles(role.getNom()).build();
    }
}
