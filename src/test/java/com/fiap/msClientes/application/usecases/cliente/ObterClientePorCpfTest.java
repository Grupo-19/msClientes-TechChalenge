package com.fiap.msClientes.application.usecases.cliente;

import com.fiap.msClientes.application.gateways.cliente.ObterClientePorCpfInterface;
import com.fiap.msClientes.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ObterClientePorCpfTest {

    @Mock
    private ObterClientePorCpfInterface obterClientePorCpfInterface;

    @InjectMocks
    private ObterClientePorCpf obterClientePorCpf;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObterClientePorCpf() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(obterClientePorCpfInterface.obterClientePorCpf(anyString())).thenReturn(cliente);

        Cliente result = obterClientePorCpf.obterClientePorCpf("12345678900");

        assertNotNull(result);
        assertEquals(cliente.getId(), result.getId());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
        assertEquals(cliente.getEmail(), result.getEmail());
        assertEquals(cliente.getSenha(), result.getSenha());
    }
}