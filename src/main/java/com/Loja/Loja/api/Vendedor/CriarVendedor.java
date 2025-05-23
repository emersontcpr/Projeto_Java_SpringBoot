package com.Loja.Loja.api.Vendedor;

public record CriarVendedor (
        String nome,
        String sobrenome,
        String nomeComercial,
        String email,
        String cnpj,
        String login,
        String senha
){
}
