package com.fiap.msClientes.infra.controller.cliente;

public record ClienteDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String senha
    ){
}
