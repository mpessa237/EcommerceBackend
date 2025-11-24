package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
