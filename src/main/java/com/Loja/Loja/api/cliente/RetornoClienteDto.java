package com.Loja.Loja.api.cliente;

public record RetornoClienteDto(
        String guid,
        String nome,
        String login
) {
}
