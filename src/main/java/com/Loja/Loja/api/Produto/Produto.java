package com.Loja.Loja.api.Produto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    public long Id ;
    public String nome;
    public String descricao;
    public Float valor;
    public Integer quantidade;
    public String categoria;
    public Long idVendedor;
    public String guid;

    public  Produto(CriarProduto dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.quantidade = dto.quantidade();
        this.categoria = dto.categoria();
        this.idVendedor = dto.idVendedor();
    }
    public  Produto(AtualizarProduto dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.quantidade = dto.quantidade();
        this.categoria = dto.categoria();
    }
}
