package com.Loja.Loja.api.Vendedor;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendedor {
    public  long id ;
    public  String nome;
    public String sobrenome;
    public  String email;
    public  String cnpj;
    public  String nomeComercial;
    public String login;
    public String senha;
    public String guid;


    public  Vendedor(CriarVendedor dto){
        this.nome=dto.nome();
        this.sobrenome=dto.sobrenome();
        this.nomeComercial=dto.nomeComercial();
        this.email=dto.email();
        this.cnpj=dto.cnpj();
        this.login=dto.login();
        this.senha=dto.senha();
    }

    public  Vendedor(AtaulizarVendedor dto){
        this.nome=dto.nome();
        this.sobrenome=dto.sobrenome();
        this.nomeComercial=dto.nomeComercial();
        this.senha=dto.senha();
    }

}



