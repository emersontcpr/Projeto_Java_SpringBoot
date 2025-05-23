package com.Loja.Loja.api.controller;

import com.Loja.Loja.api.cliente.AtualizarCliente;
import com.Loja.Loja.api.cliente.ClienteService;
import com.Loja.Loja.api.cliente.NovoClienteDTO;
import com.Loja.Loja.api.cliente.RetornoClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("clientes")
public class ClienteController {

    public final ClienteService _service;

    @Autowired
    public  ClienteController(ClienteService service){
        this._service=service;
    }
    @GetMapping("/Teste")
    public String TesteRotaCliente() {
        return "Api Rota Cliente no Ar!";
    }

    @PostMapping
    public RetornoClienteDto  CadastraCliente(@RequestBody NovoClienteDTO dados){
        return  this._service.CadastrarCliente(dados);
    }
    @GetMapping
    public List<RetornoClienteDto> ListarTodosClientes(){
        return  this._service.ListarTodosClientes();
    }

    @GetMapping("/{guid}")
    public  RetornoClienteDto ObterClientePorGuid(@PathVariable String guid){
        return  this._service.ObterClientePorGuid(guid);
    }

    @DeleteMapping("/{guid}")
    public  void     RemoverCliente(@PathVariable String guid){
        this._service.RemoverCliente(guid);
    }

    @PutMapping("/{guid}")
public void AtualizarCliente(@PathVariable String guid, AtualizarCliente dto){
       this._service.AtaulizarCliente(guid,dto);

    }

}
