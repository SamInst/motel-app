package com.example.appmotel.repository;

import com.example.appmotel.model.Troco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocoRepository extends JpaRepository<Troco, Long> {
}
