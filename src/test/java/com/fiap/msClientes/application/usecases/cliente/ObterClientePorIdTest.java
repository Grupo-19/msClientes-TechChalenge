package com.fiap.msClientes.application.usecases.cliente;

import com.fiap.msClientes.application.gateways.cliente.ObterClientePorIdInterface;
import com.fiap.msClientes.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ObterClientePorIdTest {

    @Mock
    private ObterClientePorIdInterface obterClientePorIdInterface;

    @InjectMocks
    private ObterClientePorId obterClientePorId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObterClientePorId() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(obterClientePorIdInterface.obterClientePorId(anyLong())).thenReturn(cliente);

        Cliente result = obterClientePorId.obterClientePorId(1L);

        assertNotNull(result);
        assertEquals(cliente.getId(), result.getId());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
        assertEquals(cliente.getEmail(), result.getEmail());
        assertEquals(cliente.getSenha(), result.getSenha());
    }
}