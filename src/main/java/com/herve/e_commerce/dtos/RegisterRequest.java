package com.herve.e_commerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String email;
    private String motDePasse;
    private String adresse;
    private String telephone;
}
