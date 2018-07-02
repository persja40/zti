package com.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.model.Person;
import com.boot.model.Product;;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.barCode = ?1")
    Optional<Person> findByBarCode(Integer code);
}
