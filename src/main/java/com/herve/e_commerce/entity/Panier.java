package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paniers")
public class Panier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long panierId;

    @OneToOne
    @JoinColumn(name = "acheteur_id", nullable = false)
    private Utilisateur acheteur;

    @ManyToMany
    @JoinTable(
            name = "panier_articles",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles = new ArrayList<>();
}
