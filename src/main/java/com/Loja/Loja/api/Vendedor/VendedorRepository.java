package com.Loja.Loja.api.Vendedor;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VendedorRepository {

    private List<Vendedor> vendedores = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    public  void add(Vendedor obj){
        obj.id=contador.incrementAndGet();
        this.vendedores.add(obj);
    }

    public  List<Vendedor> GetAll(){
        return  this.vendedores;
    }
    public Vendedor GetForId(long id){
        return  this.vendedores.stream().filter(x -> x.id == id).findAny().get();

    }
    public Vendedor GetForGuid(String guid){
        return  this.vendedores.stream().filter(x -> x.guid == guid).findAny().get();

    }

    public  void update(String guid, Vendedor obj) {
        Vendedor  vendedor = this.GetForGuid(guid);
        if (vendedor != null){
            if (obj.nome != null)
                vendedor.nome= obj.nome;
            if (obj.sobrenome != null)
                vendedor.sobrenome= obj.sobrenome;
            if (obj.senha != null)
                vendedor.senha= obj.senha;
            if (obj.nomeComercial != null)
                vendedor.nomeComercial= obj.nomeComercial;
        }
    }

    public  void delete(long id){
        this.vendedores =this.vendedores.stream().filter(x -> x.id != id).toList();
    }


}
