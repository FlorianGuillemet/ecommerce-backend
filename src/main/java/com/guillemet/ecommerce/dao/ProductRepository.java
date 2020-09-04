package com.guillemet.ecommerce.dao;

import com.guillemet.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // With this method below, Spring Data REST automatically exposes endpoint: "http://localhost:8080/api/products/search/findByCategoyId?id=2
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // Get the list of products that match the keyword entered.
    // Containing equals LIKE CONCAT('%', :name, '%') in SQL.
    // Spring Data REST automatically exposes endpoint: "http://localhost:8080/api/products/search/findByNameContaining?name=mouse
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
