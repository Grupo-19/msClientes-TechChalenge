package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.CadastrarClienteInterface;
import com.fiap.msClientes.entities.Cliente;

public class CadastrarCliente {

    private final CadastrarClienteInterface cadastrarClienteInterface;

    public CadastrarCliente(CadastrarClienteInterface cadastrarClienteInterface) {
        this.cadastrarClienteInterface = cadastrarClienteInterface;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return cadastrarClienteInterface.cadastrarCliente(cliente);
    }

}
