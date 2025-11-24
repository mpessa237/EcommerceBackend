package com.herve.e_commerce.services;

import com.herve.e_commerce.dtos.RegisterRequest;
import com.herve.e_commerce.entity.Utilisateur;
import com.herve.e_commerce.repository.RegisterRepo;
import com.herve.e_commerce.repository.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepo registerRepo;
    private final PasswordEncoder passwordEncoder;
    private final UtilisateurRepo utilisateurRepo;


    public void register(RegisterRequest registerRequest) {
        if (utilisateurRepo.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new IllegalArgumentException("cet email existe deja!!");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(registerRequest.getNom());
        utilisateur.setEmail(registerRequest.getEmail());
        utilisateur.setTelephone(registerRequest.getTelephone());
        utilisateur.setAdresse(registerRequest.getAdresse());
        utilisateur.setMotDePasse(passwordEncoder.encode(registerRequest.getMotDePasse()));

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_CLIENT");
        utilisateur.setRoles(roles);

         utilisateurRepo.save(utilisateur);


    }
}
