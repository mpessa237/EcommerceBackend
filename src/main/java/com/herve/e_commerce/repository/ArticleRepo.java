package com.herve.e_commerce.repository;

import com.herve.e_commerce.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
}
