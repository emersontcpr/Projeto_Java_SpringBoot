package com.Loja.Loja.api.Produto;

public record CriarProduto(
        String nome,
        String descricao,
        Float valor,
        Integer quantidade,
        String categoria,
        Long idVendedor
) {
}