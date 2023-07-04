package com.example.appmotel.controllers;


import com.example.appmotel.model.Entradas;
import com.example.appmotel.response.EntradaResponse;
import com.example.appmotel.response.EntradaSimplesResponse;
import com.example.appmotel.response.StatusEntrada;
import com.example.appmotel.services.EntradaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/entradas")
public class EntradaController {
    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }


    @GetMapping
    public List<EntradaSimplesResponse> findAll(){
        return entradaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtomicReference<EntradaResponse>> findById(@PathVariable ("id") Long id){
        return entradaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Entradas entradas(Entradas entradas){
        return entradaService.registerEntrada(entradas);
    }

    @PutMapping("/{id}")
    void atualizarEntrada (@PathVariable ("id") Long entradaID, @RequestBody Entradas entradas){
         entradaService.updateEntradaData(entradaID, entradas);
    }
    @GetMapping("/findByStatusEntrada")
    public List<Entradas> findByStatus(StatusEntrada statusEntrada){
        return entradaService.findByStatusEntrada(statusEntrada);
    }
}
