package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ObterClientePorCpfInterface;
import com.fiap.msClientes.entities.Cliente;

public class ObterClientePorCpf {

    private final ObterClientePorCpfInterface obterClientePorCpfInterface;

    public ObterClientePorCpf(ObterClientePorCpfInterface obterClientePorCpfInterface) {
        this.obterClientePorCpfInterface = obterClientePorCpfInterface;
    }

    public Cliente obterClientePorCpf(String cpf) {
        return obterClientePorCpfInterface.obterClientePorCpf(cpf);
    }
}
