package com.fiap.msClientes.application.usecases.cliente;


import com.fiap.msClientes.application.gateways.cliente.ExcluirClienteInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ExcluirClienteTest {

    @Mock
    private ExcluirClienteInterface excluirClienteInterface;

    @InjectMocks
    private ExcluirCliente excluirCliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExcluirCliente() {
        Long id = 1L;
        doNothing().when(excluirClienteInterface).excluirCliente(id);

        excluirCliente.excluirCliente(id);

        verify(excluirClienteInterface, times(1)).excluirCliente(id);
    }
}