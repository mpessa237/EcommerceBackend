package com.herve.e_commerce.controllers;

import com.herve.e_commerce.dtos.AuthenticationRequest;
import com.herve.e_commerce.dtos.AuthenticationResponse;
import com.herve.e_commerce.services.AuthenticationService;
import com.herve.e_commerce.services.DeconnexionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DeconnexionService deconnexionService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){

        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> deconnexion(HttpServletRequest httpServletRequest){
        deconnexionService.deconnexion(httpServletRequest);
        return ResponseEntity.ok("deconnexion reussie");
    }
}
