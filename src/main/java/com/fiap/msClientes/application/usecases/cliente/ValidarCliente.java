package com.fiap.msClientes.application.usecases.cliente;

import com.fiap.msClientes.application.gateways.cliente.ValidarClienteInterface;
import com.fiap.msClientes.entities.Cliente;

public class ValidarCliente {

    private final ValidarClienteInterface validarClienteInterface;

    public ValidarCliente(ValidarClienteInterface validarClienteInterface) {
        this.validarClienteInterface = validarClienteInterface;
    }

    public Boolean validarCliente(Long id) {
        return validarClienteInterface.validarCliente(id);
    }
}
