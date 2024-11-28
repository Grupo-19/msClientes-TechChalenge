package com.fiap.msClientes.application.gateways.cliente;


import com.fiap.msClientes.entities.Cliente;

public interface ObterClientePorCpfInterface {
    Cliente obterClientePorCpf(String cpf);
}
