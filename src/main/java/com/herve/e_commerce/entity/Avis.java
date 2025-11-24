package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avis")
public class Avis {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avisId;

    @Column(nullable = false)
    private Integer note; // Ex: 1 à 5

    @Column
    private String commentaire;

    @Column(nullable = false)
    private LocalDateTime dateAvis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acheteur_id", nullable = false)
    private Utilisateur acheteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
}
