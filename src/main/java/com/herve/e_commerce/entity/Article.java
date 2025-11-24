package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double prix;
    @Column(nullable = false)
    private Integer quantite;
    @Column(nullable = false)
    private Etat etat;

    @Column(name = "date_publication",nullable = false,updatable = false)
    private LocalDateTime datePublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendeur_id", nullable = false)
    private Utilisateur vendeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boutique_id", nullable = false)
    private Boutique boutique;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avis> avis = new ArrayList<>();
}
