package com.project.ProductCatalogService.repository;

import com.project.ProductCatalogService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);

    boolean existsById(Long id);

    Optional<Category> findByName(String name);

    List<Category> findByNameContainingIgnoreCase(String name);
}
