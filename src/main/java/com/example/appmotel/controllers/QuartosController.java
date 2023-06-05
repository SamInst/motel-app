package com.example.appmotel.controllers;

import com.example.appmotel.model.Quartos;
import com.example.appmotel.services.QuartosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
class QuartosController {
    private final QuartosService quartosService;

    QuartosController(QuartosService quartosService) {
        this.quartosService = quartosService;
    }

    @GetMapping
    public List<Quartos> listAll(){
        return quartosService.quartosList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quartos createQuartos(Quartos quartos){
        return quartosService.createQuartos(quartos);
    }

    @PutMapping("/{quartoID}")
    public Quartos AlterarDadoQuarto(@PathVariable ("quartoID") Long quartoId, @RequestBody Quartos quartos){
        return quartosService.updateQuartoData(quartoId, quartos);
    }
}
