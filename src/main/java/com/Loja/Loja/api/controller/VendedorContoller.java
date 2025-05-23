package com.Loja.Loja.api.controller;

import com.Loja.Loja.api.Vendedor.CriarVendedor;
import com.Loja.Loja.api.Vendedor.AtaulizarVendedor;
import com.Loja.Loja.api.Vendedor.RetornoVendedor;
import com.Loja.Loja.api.Vendedor.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedores")
public class VendedorContoller {

    public final VendedorService _service;

    @Autowired
    public  VendedorContoller(VendedorService service){
        this._service=service;
    }
    @GetMapping(value = "/Teste")
    public String TesteRotaVendedor() {
        return "Api Rota Vendedor no Ar!";

    }

    @PostMapping
    public RetornoVendedor Cadastravendedor(@RequestBody CriarVendedor dados){
        return  this._service.CadastrarVendedor(dados);
    }
    @GetMapping
    public List<RetornoVendedor> ListarTodosVendedore(){
        return  this._service.ListarTodosVendedores();
    }

    @GetMapping("/{guid}")
    public RetornoVendedor ObterVendedorPorGuid(@PathVariable String guid){
        return  this._service.ObterVendedorPorGuid(guid);
    }
    @GetMapping("/id/{id}")
    public RetornoVendedor ObterVendedorPorGuid(@PathVariable long id){
        return  this._service.ObterVendedorPorId(id);
    }

    @DeleteMapping("/{guid}")
    public  void     RemoverVendedor(@PathVariable String guid){
        this._service.RemoverVendedor(guid);
    }

    @PutMapping("/{guid}")
    public void AtualizarCliente(@PathVariable String guid, AtaulizarVendedor dto){
        this._service.AtaulizarVendedor(guid,dto);

    }
}
