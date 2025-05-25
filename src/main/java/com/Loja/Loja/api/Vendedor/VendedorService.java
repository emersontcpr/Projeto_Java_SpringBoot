package com.Loja.Loja.api.Vendedor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VendedorService {
    private final VendedorRepository vendedorRepository;


    public VendedorService(VendedorRepository  repository){
        this.vendedorRepository =repository;
    }

    public  boolean ValidarSeCpfUnico(String cnpj){
        var listVendedore  = this.vendedorRepository.GetAll();
        return listVendedore.stream().filter(x -> x.cnpj == cnpj).count() != 0;

    }
    public  boolean ValidarEmail(String email){
        var listVendedore  = this.vendedorRepository.GetAll();
        return listVendedore.stream().filter(x -> x.email == email).count() != 0;
    }
    public  boolean ValidarLogin(String login){
        var listVendedore  = this.vendedorRepository.GetAll();
        return listVendedore.stream().filter(x -> x.login == login).count() != 0;
    }

    public RetornoVendedor CadastrarVendedor(CriarVendedor dto) {
        var vendedor = new Vendedor(dto);
        var guid = UUID.randomUUID().toString();
        var isLoop = true;
        do {
            var VendedorSalvo = this.vendedorRepository.GetForGuid(guid);
            if (VendedorSalvo == null)
                isLoop = false;
            else
                guid = UUID.randomUUID().toString();
        } while (isLoop);
        vendedor.guid = guid;
        this.vendedorRepository.add(vendedor);
        return new RetornoVendedor(vendedor.id,vendedor.guid, vendedor.nome, vendedor.nomeComercial,vendedor.login);
    }
    public void AtaulizarVendedor(String guid, AtaulizarVendedor dto){
        var vendedor = new Vendedor(dto);
        this.vendedorRepository.update(guid, vendedor);

    }
    public  RetornoVendedor ObterVendedorPorGuid(String guid){
        var vendedor =  this.vendedorRepository.GetForGuid(guid);
        return new RetornoVendedor(vendedor.id,vendedor.guid, vendedor.nome,vendedor.nomeComercial, vendedor.login);
    }
    public  RetornoVendedor ObterVendedorPorId(long id){
        var vendedor =  this.vendedorRepository.GetForId(id);
        return new RetornoVendedor(vendedor.id,vendedor.guid, vendedor.nome,vendedor.nomeComercial, vendedor.login);
    }
    public List<RetornoVendedor> ListarTodosVendedores(){
        return this.vendedorRepository.GetAll().stream().map(
                        x -> new RetornoVendedor(x.id,
                                x.guid,x.nome,x.nomeComercial,x.login))
                .collect(Collectors.toList());
    }

    public  void  RemoverVendedor(String guid){
        var vendedor = this.vendedorRepository.GetForGuid(guid);
        if (vendedor != null)
            this.vendedorRepository.delete(vendedor.id);

    }
}
