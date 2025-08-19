package com.project.ProductCatalogService.repository;

import com.project.ProductCatalogService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This method retrieves all products with a price less than or equal to the specified price.
    // @Query("SELECT p FROM Product p WHERE p.price <= ?1")
    @Query("SELECT p FROM Product p WHERE p.price <= :price")
    List<Product> getProductsLessThanEqualPrice(@Param("price") double price);

    @Query(
            value = "SELECT COUNT(*) FROM Product p WHERE p.price <= :price",
            nativeQuery = true
    )
    Integer countProductsLessThanEqualPrice(@Param("price") double price);

    @Query(
            value = "SELECT COUNT(*) FROM product p WHERE p.price BETWEEN :low AND :high",
            nativeQuery = true
    )
    Integer countProductsBetweenPrice(@Param("low") double low, @Param("high") double high);
}
