package com.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdemo.entities.Product;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameAndPrice(String name, double price);
}
