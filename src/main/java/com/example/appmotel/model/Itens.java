package com.example.appmotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Itens {
    private Long id;

    private String descricao;
    private Float valor;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Itens(Long id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Itens() {
    }
}
