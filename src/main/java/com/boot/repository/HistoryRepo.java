package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.model.History;

public interface HistoryRepo extends JpaRepository<History,Integer>{

}

