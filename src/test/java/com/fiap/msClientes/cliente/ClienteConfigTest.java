package com.fiap.msClientes.cliente;
import com.fiap.msClientes.application.usecases.cliente.*;
import com.fiap.msClientes.infra.gateways.cliente.ClienteMapper;
import com.fiap.msClientes.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ClienteConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testBeansCreation() {
        assertNotNull(applicationContext.getBean(AtualizarCliente.class));
        assertNotNull(applicationContext.getBean(CadastrarCliente.class));
        assertNotNull(applicationContext.getBean(ExcluirCliente.class));
        assertNotNull(applicationContext.getBean(ObterClientePorCpf.class));
        assertNotNull(applicationContext.getBean(ObterClientePorId.class));
        assertNotNull(applicationContext.getBean(ObterTodosOsClientes.class));
        assertNotNull(applicationContext.getBean(ValidarCliente.class));
        assertNotNull(applicationContext.getBean(RepositorioDeClienteJpa.class));
        assertNotNull(applicationContext.getBean(ClienteMapper.class));
    }
}