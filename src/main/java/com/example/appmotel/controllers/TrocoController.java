package com.example.appmotel.controllers;

import com.example.appmotel.model.Troco;
import com.example.appmotel.services.TrocoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/troco")
public class TrocoController {
    private final TrocoService trocoService;

    public TrocoController(TrocoService trocoService) {
        this.trocoService = trocoService;
    }

    @GetMapping("/{troco_id}")
    public Troco buscaTroco(@PathVariable("troco_id") Long troco_id){
        return trocoService.troco(troco_id);
    }

    @PutMapping("/valor")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Troco inserirTroco(Troco troco){
        return trocoService.inserirTroco(troco);
    }
}
