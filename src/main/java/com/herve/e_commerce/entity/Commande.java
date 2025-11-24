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
@Table(name = "commandes")
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandeId;
    private LocalDateTime dateCommande;

    @Column(nullable = false)
    private StatuCommande statuCommande;

    @Column(name = "montant_total", nullable = false)
    private double montantTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acheteur_id", nullable = false)
    private Utilisateur acheteur;

    @ManyToMany
    @JoinTable(
            name = "commande_articles",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles = new ArrayList<>();

}
