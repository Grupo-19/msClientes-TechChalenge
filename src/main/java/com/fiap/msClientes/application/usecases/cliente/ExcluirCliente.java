package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ExcluirClienteInterface;

public class ExcluirCliente {

    private final ExcluirClienteInterface excluirClienteInterface;

    public ExcluirCliente(ExcluirClienteInterface excluirClienteInterface) {
        this.excluirClienteInterface = excluirClienteInterface;
    }

    public void excluirCliente(Long id) {
        excluirClienteInterface.excluirCliente(id);
    }
}
