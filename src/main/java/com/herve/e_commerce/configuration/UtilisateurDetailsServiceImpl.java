package com.herve.e_commerce.configuration;

import com.herve.e_commerce.repository.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRepo utilisateurRepo;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return this.utilisateurRepo.findByEmail(userEmail)
                .orElseThrow(()-> new RuntimeException("utilisateur non trouve"));
    }
}
