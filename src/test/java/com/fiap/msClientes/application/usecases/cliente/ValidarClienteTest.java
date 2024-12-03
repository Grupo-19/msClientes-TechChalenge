package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ValidarClienteInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ValidarClienteTest {

    @Mock
    private ValidarClienteInterface validarClienteInterface;

    @InjectMocks
    private ValidarCliente validarCliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidarCliente() {
        when(validarClienteInterface.validarCliente(anyLong())).thenReturn(true);

        Boolean result = validarCliente.validarCliente(1L);

        assertTrue(result);
    }
}