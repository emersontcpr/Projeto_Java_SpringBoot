package com.Loja.Loja.api.Produto;

public record AtualizarProduto(
        String nome,
        String descricao,
        Float valor,
        Integer quantidade,
        String categoria
) {

}
