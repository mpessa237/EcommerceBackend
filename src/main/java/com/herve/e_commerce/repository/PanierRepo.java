package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepo extends JpaRepository<Panier,Long> {
}
