package com.example.appmotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@Entity
public class Troco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Entradas entradas;
    private Float valorEntrada;
    private Float troco;

    public Troco(Entradas entradas, Float valorEntrada) {
        this.entradas = entradas;
        this.valorEntrada = valorEntrada;
    }

    public Troco() {}

    public Entradas getEntradas() {
        return entradas;
    }

    public void setEntradas(Entradas entradas) {
        this.entradas = entradas;
    }

    public Float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }
}
