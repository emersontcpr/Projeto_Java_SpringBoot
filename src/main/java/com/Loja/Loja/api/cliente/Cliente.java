package com.Loja.Loja.api.cliente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    public  Long Id;
    public  String nome;
    public String sobrenome;
    public  String email;
    public  String cpf;
    public String login;
    public String senha;
    public String guid;

    public  Cliente(NovoClienteDTO dto){
        this.nome =dto.nome();
        this.sobrenome =dto.sobrenome();
        this.email=dto.email();
        this.cpf=dto.cpf();
        this.login =dto.login();
        this.senha=dto.senha();
    }
    public  Cliente(AtualizarCliente dto){
        this.nome=dto.nome();
        this.senha=dto.senha();
        this.sobrenome=dto.sobrenome();
    }
}
