package com.example.appmotel.services;


import com.example.appmotel.model.Itens;
import com.example.appmotel.repository.ItensRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItensService {
    private final ItensRepository itensRepository;

    public ItensService(ItensRepository itensRepository) {
        this.itensRepository = itensRepository;
    }
    public List<Itens> findAll(){
        return itensRepository.findAll();
    }

    public Itens criaItens(Itens descricao){
        return itensRepository.save(descricao);
    }
}