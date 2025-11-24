package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boutiques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boutique {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boutiqueId;
    @Column(nullable = false)
    private String nom;
    private String description;

    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;

    @OneToOne
    @JoinColumn(name = "vendeur_id", nullable = false)
    private Utilisateur vendeur;

    @OneToMany(mappedBy = "boutique", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();
}
