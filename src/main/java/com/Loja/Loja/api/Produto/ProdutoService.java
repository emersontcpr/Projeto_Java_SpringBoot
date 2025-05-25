package com.Loja.Loja.api.Produto;

import com.Loja.Loja.api.Vendedor.AtaulizarVendedor;
import com.Loja.Loja.api.Vendedor.CriarVendedor;
import com.Loja.Loja.api.Vendedor.RetornoVendedor;
import com.Loja.Loja.api.Vendedor.Vendedor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {
    private  final ProdutoRepository _produtoRepository;

    public  ProdutoService(ProdutoRepository produtoRepository){

        _produtoRepository = produtoRepository;
    }
    public List<RetornoProduto> ListarTodosProdutosVendedores(long idVendedor){
return  _produtoRepository.GetForIdVendedor(idVendedor).stream().map(
        x -> new RetornoProduto(x.guid,x.nome,x.valor,x.descricao,x.idVendedor)
).toList();
    }

    public RetornoProduto CadastrarProduto(CriarProduto dto) {
        var produto = new Produto(dto);
        var guid = UUID.randomUUID().toString();
        var isLoop = true;
        do {
            var produtoSalvo = this._produtoRepository.GetForGuid(guid);
            if (produtoSalvo == null)
                isLoop = false;
            else
                guid = UUID.randomUUID().toString();
        } while (isLoop);
        produto.guid = guid;
        this._produtoRepository.add(produto);
        return new RetornoProduto(
                produto.guid,produto.nome,produto.valor,produto.descricao,produto.idVendedor
        );
    }

public  RetornoProduto ObterProdutoPorGuid(String guid) {
    var produto = this._produtoRepository.GetForGuid(guid);
    return new RetornoProduto(
            produto.guid, produto.nome, produto.valor, produto.descricao, produto.idVendedor
    );
}
    public  void  RemoverProduto(String guid){
        var produto = this._produtoRepository.GetForGuid(guid);
        if (produto != null)
            this._produtoRepository.delete(produto.Id);

    }

    public void AtaulizarProduto(String guid, AtualizarProduto dto){
        var produto = new Produto(dto);
        this._produtoRepository.update(guid, produto);

    }

}
