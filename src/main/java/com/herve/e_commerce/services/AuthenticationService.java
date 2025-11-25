package com.herve.e_commerce.services;

import com.herve.e_commerce.configuration.JwtService;
import com.herve.e_commerce.dtos.AuthenticationRequest;
import com.herve.e_commerce.dtos.AuthenticationResponse;
import com.herve.e_commerce.repository.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepo utilisateurRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getMotDePasse()
                )
        );

        var utilisateur = utilisateurRepo.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(()->new IllegalArgumentException("utilisateur non trouve"));

        var accessToken = jwtService.generateAccessToken(utilisateur);
        var refreshToken = jwtService.generateRefreshToken(utilisateur);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccessToken(accessToken);
        authenticationResponse.setRefreshToken(refreshToken);

        return authenticationResponse;
    }
}
