package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ObterTodosOsClientesInterface;
import com.fiap.msClientes.entities.Cliente;

import java.util.List;

public class ObterTodosOsClientes {

    private final ObterTodosOsClientesInterface obterTodosOsClientesInterface;

    public ObterTodosOsClientes(ObterTodosOsClientesInterface obterTodosOsClientesInterface) {
        this.obterTodosOsClientesInterface = obterTodosOsClientesInterface;
    }

    public List<Cliente> obterTodosOsClientes() {
        return obterTodosOsClientesInterface.obterTodosOsClientesInterface();
    }
}
