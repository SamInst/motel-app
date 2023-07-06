package com.example.appmotel.exceptions.handler;

public record ErrorMessage(
        String projeto,
        String apiPath,
        String error,
        String descricao,
        String exception
) {
}
