package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateurId;
    @Column(nullable = false, unique = true)
    private String nom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String motDePasse;
    private String adresse;
    private String telephone;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "utilisateur_roles", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @OneToMany(mappedBy = "vendeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Article> articles = new HashSet<>();

    @OneToMany(mappedBy = "acheteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Commande> commandes = new HashSet<>();

    @OneToOne(mappedBy = "vendeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Boutique boutique;

    @OneToOne(mappedBy = "acheteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Panier panier;
}
