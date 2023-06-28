package com.example.appmotel.response;

public record ConsumoResponse(
        Integer quantidade,
        String item,
        Float valor,
        Float total
) {
}
