package com.Loja.Loja.api.Produto;

public record RetornoProduto (
        String guid,
        String nome,
        Float valor,
        String descricao,
        Long idVendador
){
}
