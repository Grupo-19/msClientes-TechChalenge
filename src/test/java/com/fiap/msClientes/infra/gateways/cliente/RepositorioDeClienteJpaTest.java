package com.fiap.msClientes.infra.gateways.cliente;


import com.fiap.msClientes.application.gateways.cliente.*;
import com.fiap.msClientes.entities.Cliente;
import com.fiap.msClientes.infra.gateways.cliente.ClienteMapper;
import com.fiap.msClientes.infra.gateways.cliente.RepositorioDeClienteJpa;
import com.fiap.msClientes.infra.persistence.cliente.ClienteEntity;
import com.fiap.msClientes.infra.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepositorioDeClienteJpaTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private RepositorioDeClienteJpa repositorioDeClienteJpa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAtualizarCliente() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(entity);
        when(clienteMapper.toDomain(any(ClienteEntity.class))).thenReturn(cliente);

        Cliente result = repositorioDeClienteJpa.atualizarCliente(cliente);

        assertNotNull(result);
        assertEquals(cliente.getId(), result.getId());
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }

    @Test
    void testCadastrarCliente() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteMapper.toEntity(any(Cliente.class))).thenReturn(entity);
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(entity);
        when(clienteMapper.toDomain(any(ClienteEntity.class))).thenReturn(cliente);

        Cliente result = repositorioDeClienteJpa.cadastrarCliente(cliente);

        assertNotNull(result);
        assertEquals(cliente.getId(), result.getId());
        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }

    @Test
    void testExcluirCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        repositorioDeClienteJpa.excluirCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    void testObterClientePorCpf() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.of(entity));
        when(clienteMapper.toDomain(any(ClienteEntity.class))).thenReturn(cliente);

        Cliente result = repositorioDeClienteJpa.obterClientePorCpf("12345678900");

        assertNotNull(result);
        assertEquals(cliente.getCpf(), result.getCpf());
        verify(clienteRepository, times(1)).findByCpf("12345678900");
    }

    @Test
    void testObterClientePorId() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(clienteMapper.toDomain(any(ClienteEntity.class))).thenReturn(cliente);

        Cliente result = repositorioDeClienteJpa.obterClientePorId(1L);

        assertNotNull(result);
        assertEquals(cliente.getId(), result.getId());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testObterTodosOsClientesInterface() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteRepository.findAll()).thenReturn(List.of(entity));
        when(clienteMapper.toDomain(any(ClienteEntity.class))).thenReturn(cliente);

        List<Cliente> result = repositorioDeClienteJpa.obterTodosOsClientesInterface();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testValidarCliente() {
        ClienteEntity entity = new ClienteEntity(1L, "Nome", "12345678900", "email@example.com", "senha");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(entity));

        Boolean result = repositorioDeClienteJpa.validarCliente(1L);

        assertTrue(result);
        verify(clienteRepository, times(1)).findById(1L);
    }
}
