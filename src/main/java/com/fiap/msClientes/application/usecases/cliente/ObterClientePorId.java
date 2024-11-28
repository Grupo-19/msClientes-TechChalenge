package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ObterClientePorIdInterface;
import com.fiap.msClientes.entities.Cliente;

public class ObterClientePorId {

    private final ObterClientePorIdInterface obterClientePorIdInterface;

    public ObterClientePorId(ObterClientePorIdInterface obterClientePorIdInterface) {
        this.obterClientePorIdInterface = obterClientePorIdInterface;
    }

    public Cliente obterClientePorId(Long id) {
        return obterClientePorIdInterface.obterClientePorId(id);
    }
}
