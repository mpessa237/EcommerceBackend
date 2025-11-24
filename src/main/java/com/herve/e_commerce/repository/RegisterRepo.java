package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Utilisateur,Long> {
}
