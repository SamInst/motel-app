package com.example.appmotel.repository;

import com.example.appmotel.model.Quartos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartosRepository extends JpaRepository<Quartos, Long> {
}
