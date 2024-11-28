package com.fiap.msClientes.infra.gateways.cliente;


import com.fiap.msClientes.entities.Cliente;
import com.fiap.msClientes.infra.persistence.cliente.ClienteEntity;

public class ClienteMapper {

    public Cliente toDomain(ClienteEntity input){
        return new Cliente(
                input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getEmail(),
                input.getSenha()
        );
    }

    public ClienteEntity toEntity(Cliente input){
        return new ClienteEntity(
                input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getEmail(),
                input.getSenha()
        );
    }
}
