package com.example.appmotel.model;

import com.example.appmotel.response.StatusDoQuarto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quartos {
    @Id
    private Long id;
    private Integer numero;
    private String descricao;
    private Integer capacidadePessoa;
    private StatusDoQuarto statusDoQuarto;

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public Integer getNumero() {
        return numero;
    }
    public String getDescricao() {
        return descricao;
    }
    public Integer getCapacidadePessoa() {
        return capacidadePessoa;
    }
    public StatusDoQuarto getStatusDoQuarto() {
        return statusDoQuarto;
    }
    public void setStatusDoQuarto(StatusDoQuarto statusDoQuarto) {
        this.statusDoQuarto = statusDoQuarto;
    }

    public Quartos(Long id, Integer numero, String descricao, Integer capacidadePessoa, StatusDoQuarto statusDoQuarto) {
        this.id = id;
        this.numero = numero;
        this.descricao = descricao;
        this.capacidadePessoa = capacidadePessoa;
        this.statusDoQuarto = statusDoQuarto;
    }
    public Quartos() {
    }
}
