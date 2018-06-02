package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
