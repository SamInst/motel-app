package com.example.appmotel.feign;

import com.example.appmotel.model.Quartos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "quartos-consumer", url = "localhost:8080/quartos")
public interface QuartosFeing {
    @GetMapping
    List<Quartos> findQuartosFeing();

    @GetMapping("/find/{id}")
    public Quartos findById(@PathVariable ("id") Long id);

    @PutMapping("/{quartoID}")
    Quartos alterarDadoQuarto(@PathVariable ("quartoID") Long quartoId, @RequestBody Quartos quartos);

    @PostMapping
    Quartos saveQuartos(@RequestBody Quartos quartos);
}
