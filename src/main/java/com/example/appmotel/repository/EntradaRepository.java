package com.example.appmotel.repository;

import com.example.appmotel.model.Entradas;
import com.example.appmotel.response.StatusEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entradas, Long> {
//    List<Entradas> findByApt(Integer apt);

    List<Entradas> findEntradasByStatusEntrada(StatusEntrada statusEntrada);
}