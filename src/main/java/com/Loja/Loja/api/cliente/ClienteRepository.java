package com.Loja.Loja.api.cliente;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    public  void add(Cliente obj){
        obj.Id=contador.incrementAndGet();
        this.clientes.add(obj);
    }
    public  List<Cliente> GetAll(){
        return  this.clientes;
    }
    public Cliente GetForId(long id){
        return  this.clientes.stream().filter(x -> x.Id == id).findAny().get();

    }
    public Cliente GetForGuid(String guid){
        return  this.clientes.stream().filter(x -> x.guid == guid).findAny().get();

    }

    public  void update(String guid, Cliente obj) {
        Cliente  cliente = this.GetForGuid(guid);
        if (cliente != null){
            if (obj.nome != null)
                cliente.nome= obj.nome;
            if (obj.sobrenome != null)
                cliente.sobrenome= obj.sobrenome;
            if (obj.senha != null)
                cliente.senha= obj.senha;
        }
        }

        public  void delete(long id){
        this.clientes =this.clientes.stream().filter(x -> x.Id != id).toList();
        }

    }


