package com.Loja.Loja.api.cliente;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository  repository){
        this.clienteRepository =repository;
    }
    public  boolean ValidarSeCpfUnico(String cpf){
        var listCliente  = this.clienteRepository.GetAll();
        return listCliente.stream().filter(x -> x.cpf == cpf).count() != 0;

    }
    public  boolean ValidarEmail(String email){
        var listCliente  = this.clienteRepository.GetAll();
        return listCliente.stream().filter(x -> x.email == email).count() != 0;
    }
    public  boolean ValidarLogin(String login){
        var listCliente  = this.clienteRepository.GetAll();
        return listCliente.stream().filter(x -> x.login == login).count() != 0;
    }
    public  RetornoClienteDto  CadastrarCliente(NovoClienteDTO dto) {
        var cliente = new Cliente(dto);
        var guid = UUID.randomUUID().toString();
        var isLoop = true;
        do {
            var clienteSalvo = this.clienteRepository.GetForGuid(guid);
            if (clienteSalvo == null)
                isLoop = false;
            else
                guid = UUID.randomUUID().toString();
        } while (isLoop);
        cliente.guid = guid;
        this.clienteRepository.add(cliente);
        return new RetornoClienteDto(cliente.guid, cliente.nome, cliente.login);
    }
    public  RetornoClienteDto ObterClientePorGuid(String guid){
        var cliente =  this.clienteRepository.GetForGuid(guid);
        return new RetornoClienteDto(cliente.guid, cliente.nome, cliente.login);
    }
    public List<RetornoClienteDto>  ListarTodosClientes(){
        return this.clienteRepository.GetAll().stream().map(
                x -> new RetornoClienteDto(x.guid,x.nome,x.login))
                .collect(Collectors.toList());
    }
    public  void  RemoverCliente(String guid){
        var cliente = this.clienteRepository.GetForGuid(guid);
        if (cliente != null)
            this.clienteRepository.delete(cliente.Id);

    }

    public void AtaulizarCliente(String guid, AtualizarCliente  dto){
        var cliente = new Cliente(dto);
this.clienteRepository.update(guid, cliente);

    }

}
