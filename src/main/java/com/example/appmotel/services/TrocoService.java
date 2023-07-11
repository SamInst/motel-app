package com.example.appmotel.services;

import com.example.appmotel.exceptions.EntityConflict;
import com.example.appmotel.exceptions.EntityNotFound;
import com.example.appmotel.model.Troco;
import com.example.appmotel.repository.EntradaRepository;
import com.example.appmotel.repository.TrocoRepository;
import org.springframework.stereotype.Service;

@Service
public class TrocoService {
    private final TrocoRepository trocoRepository;
    private final EntradaRepository entradaRepository;
    public TrocoService(TrocoRepository trocoRepository, EntradaRepository entradaRepository) {
        this.trocoRepository = trocoRepository;
        this.entradaRepository = entradaRepository;
    }

    public Troco troco(Long id){
        return trocoRepository.findById(id).orElseThrow(
                ()-> new EntityNotFound("troco inválido"));
    }

    public Troco inserirTroco(Troco troco){
        final var entrada = entradaRepository.findById(troco.getEntradas().getId())
                .orElseThrow(()-> new EntityNotFound("Entrada não existe"));

        Float trocoFinal = troco.getValorEntrada() - entrada.getTotal_entrada();
        troco.setTroco(trocoFinal);
        if (trocoFinal < 0){
            throw new EntityConflict("O valor ficou negativo, verifique o valor inserido e tente novamente");
        }
        return trocoRepository.save(troco);
    }
}
