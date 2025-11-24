package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepo extends JpaRepository<Avis,Long> {
}
