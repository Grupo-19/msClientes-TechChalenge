package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.AtualizarClienteInterface;
import com.fiap.msClientes.entities.Cliente;

public class AtualizarCliente {
    private final AtualizarClienteInterface atualizarClienteInterface;

    public AtualizarCliente(AtualizarClienteInterface atualizarClienteInterface) {
        this.atualizarClienteInterface = atualizarClienteInterface;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return atualizarClienteInterface.atualizarCliente(cliente);
    }
}
