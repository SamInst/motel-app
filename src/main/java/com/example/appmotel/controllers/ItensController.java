package com.example.appmotel.controllers;

import com.example.appmotel.model.Itens;
import com.example.appmotel.services.ItensService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItensController {
    private final ItensService itensService;

    public ItensController(ItensService itensService) {
        this.itensService = itensService;
    }
    @GetMapping
    public List<Itens> itensList (){
        return itensService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Itens criaItens(@RequestBody Itens descricao){
        return itensService.criaItens(descricao);
    }
}
