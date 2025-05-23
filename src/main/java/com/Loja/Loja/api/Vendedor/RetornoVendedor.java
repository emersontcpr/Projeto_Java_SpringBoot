package com.Loja.Loja.api.Vendedor;

public record RetornoVendedor(
        long id,
        String guid,
        String nome,
        String nomeComercial,
        String  login
) {
}
