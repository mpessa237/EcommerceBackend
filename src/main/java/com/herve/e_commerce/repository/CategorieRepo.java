package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Boutique,Long> {
}
