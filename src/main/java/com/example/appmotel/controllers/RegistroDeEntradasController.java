package com.example.appmotel.controllers;

import com.example.appmotel.model.RegistroDeEntradas;
import com.example.appmotel.repository.RegistroDeEntradasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/registroEntradas")
public class RegistroDeEntradasController {
    private final RegistroDeEntradasRepository registroDeEntradasRepository;

    public RegistroDeEntradasController(RegistroDeEntradasRepository registroDeEntradasRepository) {
        this.registroDeEntradasRepository = registroDeEntradasRepository;
    }

    @GetMapping
    public List<RegistroDeEntradas> findAll(){
        return registroDeEntradasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RegistroDeEntradas> findById(@PathVariable ("id") Long id){
        return registroDeEntradasRepository.findById(id);
    }
    @GetMapping("/buscar-por-data")
    public List<RegistroDeEntradas> findByData(LocalDate data_entrada){
        return registroDeEntradasRepository.findByData(data_entrada);
    }
}
