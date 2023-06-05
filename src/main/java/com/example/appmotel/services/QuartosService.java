package com.example.appmotel.services;

import com.example.appmotel.exceptions.EntityNotFound;
import com.example.appmotel.model.Quartos;
import com.example.appmotel.repository.QuartosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartosService {
    Quartos quartos;

    private final QuartosRepository quartosRepository;

    public QuartosService(QuartosRepository quartosRepository) {
        this.quartosRepository = quartosRepository;
    }

    public List<Quartos> quartosList() {
        return quartosRepository.findAll();
    }

    public Quartos findQuarto(Long id) {
        return quartosRepository.findById(id).orElseThrow(() -> new EntityNotFound("Quarto não existe"));
    }

    public Quartos createQuartos(Quartos quartos) {
        return quartosRepository.save(quartos);
    }

    public Quartos updateQuartoData(Long quartoId, Quartos request) {
        quartos = quartosRepository.findById(quartoId).orElseThrow(() -> new EntityNotFound("Quarto não encontrado"));

        var quartoAtualizado = new Quartos(
                quartos.getId(),
                quartos.getNumero(),
                quartos.getDescricao(),
                quartos.getCapacidadePessoa(),
                request.getStatusDoQuarto()
        );
        quartosRepository.save(quartoAtualizado);
        return quartoAtualizado;
    }
}
