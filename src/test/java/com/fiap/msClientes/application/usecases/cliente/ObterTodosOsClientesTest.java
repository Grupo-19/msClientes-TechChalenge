package com.fiap.msClientes.application.usecases.cliente;

import com.fiap.msClientes.application.gateways.cliente.ObterTodosOsClientesInterface;
import com.fiap.msClientes.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ObterTodosOsClientesTest {

    @Mock
    private ObterTodosOsClientesInterface obterTodosOsClientesInterface;

    @InjectMocks
    private ObterTodosOsClientes obterTodosOsClientes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObterTodosOsClientes() {
        Cliente cliente1 = new Cliente(1L, "Nome1", "12345678900", "email1@example.com", "senha1");
        Cliente cliente2 = new Cliente(2L, "Nome2", "09876543211", "email2@example.com", "senha2");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        when(obterTodosOsClientesInterface.obterTodosOsClientesInterface()).thenReturn(clientes);

        List<Cliente> result = obterTodosOsClientes.obterTodosOsClientes();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(cliente1.getId(), result.get(0).getId());
        assertEquals(cliente2.getId(), result.get(1).getId());
    }
}