package com.example.appmotel.exceptions.handler;

public record ErroDeValidacao(
         String campo,
         String mensagem
){
    private static class ErroDeValidacaoBuilder{
    }
}
