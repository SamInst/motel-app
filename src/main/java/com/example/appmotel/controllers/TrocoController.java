package com.example.appmotel.controllers;

import com.example.appmotel.model.Troco;
import com.example.appmotel.services.TrocoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/troco")
public class TrocoController {
    private final TrocoService trocoService;
    public TrocoController(TrocoService trocoService) { this.trocoService = trocoService; }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Troco troco(Troco troco){ return trocoService.passarTroco(troco); }
}
