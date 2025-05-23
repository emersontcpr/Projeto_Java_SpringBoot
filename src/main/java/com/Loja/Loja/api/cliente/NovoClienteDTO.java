package com.Loja.Loja.api.cliente;



public record NovoClienteDTO(
        String nome,
        String sobrenome,
        String email,
        String cpf,
        String login,
        String senha
){
}
