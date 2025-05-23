package com.Loja.Loja.api.controller;

import com.Loja.Loja.api.cliente.ClienteService;
import com.Loja.Loja.api.cliente.NovoClienteDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoContoller {


    @GetMapping(value = "/Teste")
    public String TesteRotaProduto() {
        return "Api Rota Produto no Ar!";

    }

}
