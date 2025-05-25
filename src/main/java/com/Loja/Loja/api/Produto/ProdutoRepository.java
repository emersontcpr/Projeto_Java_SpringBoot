package com.Loja.Loja.api.Produto;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    public  void add(Produto obj){
        obj.Id=contador.incrementAndGet();
        this.produtos.add(obj);
    }

    public  List<Produto> GetAll(){
        return  this.produtos;
    }
    public Produto GetForId(long id){
        return  this.produtos.stream().filter(x -> x.Id == id).findAny().get();

    }
    public List<Produto> GetForIdVendedor(long IdVendedor){
        return  this.produtos.stream().filter(x -> x.idVendedor == IdVendedor).toList();

    }
    public Produto GetForGuid(String guid){
        return  this.produtos.stream().filter(x -> x.guid == guid).findAny().get();

    }

    public  void update(String guid, Produto obj) {
        Produto  produto = this.GetForGuid(guid);
        if (produto != null){
            if (obj.nome != null)
                produto.nome= obj.nome;
            if (obj.descricao != null)
                produto.descricao= obj.descricao;
            if (obj.valor != null)
                produto.valor= obj.valor;
            if (obj.quantidade != null)
                produto.quantidade= obj.quantidade;
            if (obj.categoria != null)
                produto.categoria= obj.categoria;
        }
    }

    public  void delete(long id){
        this.produtos =this.produtos.stream().filter(x -> x.Id != id).toList();
    }
}
