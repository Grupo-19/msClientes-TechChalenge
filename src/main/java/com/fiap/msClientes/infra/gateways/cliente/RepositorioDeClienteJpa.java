package com.fiap.msClientes.infra.gateways.cliente;


import com.fiap.msClientes.application.gateways.cliente.*;
import com.fiap.msClientes.entities.Cliente;
import com.fiap.msClientes.infra.persistence.cliente.ClienteEntity;
import com.fiap.msClientes.infra.persistence.cliente.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeClienteJpa implements
        AtualizarClienteInterface,
        CadastrarClienteInterface,
        ExcluirClienteInterface,
        ObterClientePorCpfInterface,
        ObterClientePorIdInterface,
        ObterTodosOsClientesInterface {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public RepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        ClienteEntity entity = clienteRepository.findById(cliente.getId()).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        entity.setNome(cliente.getNome());
        entity.setCpf(cliente.getCpf());
        entity.setEmail(cliente.getEmail());
        entity.setSenha(cliente.getSenha());
        return clienteMapper.toDomain(clienteRepository.save(entity));
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity entity = clienteMapper.toEntity(cliente);
        return clienteMapper.toDomain(clienteRepository.save(entity));
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente obterClientePorCpf(String cpf) {
        ClienteEntity entity = clienteRepository.findByCpf(cpf).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDomain(entity);
    }

    @Override
    public Cliente obterClientePorId(Long id) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDomain(entity);
    }

    @Override
    public List<Cliente> obterTodosOsClientesInterface() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDomain)
                .collect(Collectors.toList());
    }
}
