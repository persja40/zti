package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.model.Product;;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
