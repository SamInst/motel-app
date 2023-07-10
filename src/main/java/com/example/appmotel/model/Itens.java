package com.example.appmotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Itens {
    @Id
    private Long id;
    private String descricao;
    private Float valor;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDescricao() {return descricao;}
    public Float getValor() {return valor;}

    public Itens(Long id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
    public Itens(String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Itens(String descricao) {
        this.descricao = descricao;
    }

    public Itens() {
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
