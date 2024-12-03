package com.fiap.msClientes.infra.gateways.cliente;


import com.fiap.msClientes.entities.Cliente;
import com.fiap.msClientes.infra.persistence.cliente.ClienteEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteMapperTest {

    private final ClienteMapper clienteMapper = new ClienteMapper();

    @Test
    void testToDomain() {
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");
        Cliente cliente = clienteMapper.toDomain(entity);

        assertNotNull(cliente);
        assertEquals(entity.getId(), cliente.getId());
        assertEquals(entity.getNome(), cliente.getNome());
        assertEquals(entity.getCpf(), cliente.getCpf());
        assertEquals(entity.getEmail(), cliente.getEmail());
        assertEquals(entity.getSenha(), cliente.getSenha());
    }

    @Test
    void testToEntity() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = clienteMapper.toEntity(cliente);

        assertNotNull(entity);
        assertEquals(cliente.getId(), entity.getId());
        assertEquals(cliente.getNome(), entity.getNome());
        assertEquals(cliente.getCpf(), entity.getCpf());
        assertEquals(cliente.getEmail(), entity.getEmail());
        assertEquals(cliente.getSenha(), entity.getSenha());
    }
}