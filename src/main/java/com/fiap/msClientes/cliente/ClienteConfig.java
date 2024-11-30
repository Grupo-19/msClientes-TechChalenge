package com.fiap.msClientes.cliente;

import com.fiap.msClientes.application.gateways.cliente.*;
import com.fiap.msClientes.application.usecases.cliente.*;
import com.fiap.msClientes.infra.gateways.cliente.ClienteMapper;
import com.fiap.msClientes.infra.gateways.cliente.RepositorioDeClienteJpa;
import com.fiap.msClientes.infra.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    AtualizarCliente atualizarCliente(AtualizarClienteInterface atualizarClienteInterface){
        return new AtualizarCliente(atualizarClienteInterface);
    }

    @Bean
    CadastrarCliente cadastrarCliente(CadastrarClienteInterface cadastrarClienteInterface){
        return new CadastrarCliente(cadastrarClienteInterface);
    }

    @Bean
    ExcluirCliente excluirCliente(ExcluirClienteInterface excluirClienteInterface){
        return new ExcluirCliente(excluirClienteInterface);
    }

    @Bean
    ObterClientePorCpf obterClientePorCpf(ObterClientePorCpfInterface obterClientePorCpfInterface){
        return new ObterClientePorCpf(obterClientePorCpfInterface);
    }

    @Bean
    ObterClientePorId obterClientePorId(ObterClientePorIdInterface obterClientePorIdInterface){
        return new ObterClientePorId(obterClientePorIdInterface);
    }

    @Bean
    ObterTodosOsClientes obterTodosOsClientes(ObterTodosOsClientesInterface obterTodosOsClientesInterface){
        return new ObterTodosOsClientes(obterTodosOsClientesInterface);
    }

    @Bean
    ValidarCliente validarCliente(ValidarClienteInterface validarClienteInterface){
        return new ValidarCliente(validarClienteInterface);
    }

    @Bean
    RepositorioDeClienteJpa repositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper mapper){
        return new RepositorioDeClienteJpa(clienteRepository, mapper);
    }

    @Bean
    ClienteMapper clienteMapper(){
        return new ClienteMapper();
    }

}
