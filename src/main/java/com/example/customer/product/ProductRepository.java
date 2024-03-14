package com.example.customer.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT s FROM Product s WHERE s.product_name = ?1")
    Optional<Product> findProductByName(String product_name);
}

