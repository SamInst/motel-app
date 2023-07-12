package com.example.appmotel.services;

import com.example.appmotel.exceptions.EntityConflict;
import com.example.appmotel.exceptions.EntityNotFound;
import com.example.appmotel.model.Troco;
import com.example.appmotel.repository.EntradaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrocoService {
    private final EntradaRepository entradaRepository;

    public TrocoService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    public Troco passarTroco(Troco troco){
        final var entrada = entradaRepository.findById(troco.getEntradas().getId())
                .orElseThrow(()-> new EntityNotFound("Entrada não existe")
        );
        float trocoFinal = troco.getValorEntrada() - entrada.getTotal_entrada();
        troco.setTroco(trocoFinal);
        if (trocoFinal < 0){
            throw new EntityConflict("O valor ficou negativo, verifique o valor inserido e tente novamente");
        }
        return troco;
    }
}
