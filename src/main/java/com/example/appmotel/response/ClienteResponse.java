package com.example.appmotel.response;

public record ClienteResponse(
        String nome,
        String CPF,
        String telefone,
        String endereco,
        String profissao
){}
