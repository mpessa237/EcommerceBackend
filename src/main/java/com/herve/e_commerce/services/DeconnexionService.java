package com.herve.e_commerce.services;

import com.herve.e_commerce.configuration.JwtService;
import com.herve.e_commerce.entity.RevokedToken;
import com.herve.e_commerce.repository.RevokedTokenRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeconnexionService {

    private final RevokedTokenRepo revokedTokenRepo;
    private final JwtService jwtService;

    @Transactional
    public void deconnexion(HttpServletRequest httpServletRequest){

        final String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader==null || !authHeader.startsWith("Bearer")){
            return;
        }

        String jwt = authHeader.substring(7);

        // Sauvegarder le token dans la liste noire avec sa durée de vie restante
        long expirationTime = jwtService.extractExpiration(jwt).getTime();

        RevokedToken revokedToken = RevokedToken.builder()
                .token(jwt)
                .expirationTime(expirationTime)
                .build();

        revokedTokenRepo.save(revokedToken);

        SecurityContextHolder.clearContext();
    }
}
