package com.Loja.Loja.api.controller;

import com.Loja.Loja.api.Produto.AtualizarProduto;
import com.Loja.Loja.api.Produto.CriarProduto;
import com.Loja.Loja.api.Produto.ProdutoService;
import com.Loja.Loja.api.Produto.RetornoProduto;
import com.Loja.Loja.api.Vendedor.AtaulizarVendedor;
import com.Loja.Loja.api.Vendedor.CriarVendedor;
import com.Loja.Loja.api.Vendedor.RetornoVendedor;
import com.Loja.Loja.api.Vendedor.VendedorService;
import com.Loja.Loja.api.cliente.ClienteService;
import com.Loja.Loja.api.cliente.NovoClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoContoller {
    public final ProdutoService _service;

    @Autowired
    public  ProdutoContoller(ProdutoService service){
        this._service=service;
    }

    @GetMapping(value = "/Teste")
    public String TesteRotaProduto() {
        return "Api Rota Produto no Ar!";

    }
    @PostMapping
    public RetornoProduto Cadastravendedor(@RequestBody CriarProduto dados){
        return  this._service.CadastrarProduto(dados);
    }

    @GetMapping("/listarTodos/:idVendedor")
    public List<RetornoProduto> ListarTodosProdutosPorVendedor(@PathVariable long idVendedor){
        return  this._service.ListarTodosProdutosVendedores(idVendedor);
    }
    @GetMapping("/{guid}")
    public RetornoProduto ObterProdutoPorGuid(@PathVariable String guid){
        return  this._service.ObterProdutoPorGuid(guid);
    }

    @DeleteMapping("/{guid}")
    public  void     RemoverProduto(@PathVariable String guid){
        this._service.RemoverProduto(guid);
    }

    @PutMapping("/{guid}")
    public void AtualizarProduto(@PathVariable String guid, AtualizarProduto dto){
        this._service.AtaulizarProduto(guid,dto);
    }


}
