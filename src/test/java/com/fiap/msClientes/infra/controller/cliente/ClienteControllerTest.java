package com.fiap.msClientes.infra.controller.cliente;


import com.fiap.msClientes.application.usecases.cliente.*;
import com.fiap.msClientes.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AtualizarCliente atualizarCliente;

    @Mock
    private CadastrarCliente cadastrarCliente;

    @Mock
    private ExcluirCliente excluirCliente;

    @Mock
    private ObterClientePorCpf obterClientePorCpf;

    @Mock
    private ObterClientePorId obterClientePorId;

    @Mock
    private ObterTodosOsClientes obterTodosOsClientes;

    @Mock
    private ValidarCliente validarCliente;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void testAtualizarCliente() throws Exception {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(atualizarCliente.atualizarCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(put("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Nome\",\"cpf\":\"12345678900\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cpf").value("12345678900"))
                .andExpect(jsonPath("$.email").value("email@example.com"))
                .andExpect(jsonPath("$.senha").value("senha"));

        verify(atualizarCliente, times(1)).atualizarCliente(any(Cliente.class));
    }

    @Test
    void testCadastrarCliente() throws Exception {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(cadastrarCliente.cadastrarCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Nome\",\"cpf\":\"12345678900\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cpf").value("12345678900"))
                .andExpect(jsonPath("$.email").value("email@example.com"))
                .andExpect(jsonPath("$.senha").value("senha"));

        verify(cadastrarCliente, times(1)).cadastrarCliente(any(Cliente.class));
    }

    @Test
    void testExcluirCliente() throws Exception {
        doNothing().when(excluirCliente).excluirCliente(1L);

        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isOk());

        verify(excluirCliente, times(1)).excluirCliente(1L);
    }

    @Test
    void testObterClientePorCpf() throws Exception {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(obterClientePorCpf.obterClientePorCpf("12345678900")).thenReturn(cliente);

        mockMvc.perform(get("/clientes/cpf/12345678900"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cpf").value("12345678900"))
                .andExpect(jsonPath("$.email").value("email@example.com"))
                .andExpect(jsonPath("$.senha").value("senha"));

        verify(obterClientePorCpf, times(1)).obterClientePorCpf("12345678900");
    }

    @Test
    void testObterClientePorId() throws Exception {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(obterClientePorId.obterClientePorId(1L)).thenReturn(cliente);

        mockMvc.perform(get("/clientes/id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cpf").value("12345678900"))
                .andExpect(jsonPath("$.email").value("email@example.com"))
                .andExpect(jsonPath("$.senha").value("senha"));

        verify(obterClientePorId, times(1)).obterClientePorId(1L);
    }

    @Test
    void testObterTodosOsClientes() throws Exception {
        Cliente cliente = new Cliente(1L, "Nome", "12345678900", "email@example.com", "senha");
        when(obterTodosOsClientes.obterTodosOsClientes()).thenReturn(List.of(cliente));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("Nome"))
                .andExpect(jsonPath("$[0].cpf").value("12345678900"))
                .andExpect(jsonPath("$[0].email").value("email@example.com"))
                .andExpect(jsonPath("$[0].senha").value("senha"));

        verify(obterTodosOsClientes, times(1)).obterTodosOsClientes();
    }

    @Test
    void testValidarCliente() throws Exception {
        when(validarCliente.validarCliente(1L)).thenReturn(true);

        mockMvc.perform(get("/clientes/consultar/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(validarCliente, times(1)).validarCliente(1L);
    }
}