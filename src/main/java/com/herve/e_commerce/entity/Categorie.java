package com.herve.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorieId;
    @Column(nullable = false,unique = true)
    private String nom;
    private String description;
}
