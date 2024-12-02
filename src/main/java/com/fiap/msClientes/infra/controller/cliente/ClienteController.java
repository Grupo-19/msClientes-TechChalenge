package com.fiap.msClientes.infra.controller.cliente;

import com.fiap.msClientes.application.usecases.cliente.*;
import com.fiap.msClientes.entities.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes")
public class ClienteController {

    private final AtualizarCliente atualizarCliente;
    private final CadastrarCliente cadastrarCliente;
    private final ExcluirCliente excluirCliente;
    private final ObterClientePorCpf obterClientePorCpf;
    private final ObterClientePorId obterClientePorId;
    private final ObterTodosOsClientes obterTodosOsClientes;
    private final ValidarCliente validarCliente;

    public ClienteController(AtualizarCliente atualizarCliente, CadastrarCliente cadastrarCliente, ExcluirCliente excluirCliente, ObterClientePorCpf obterClientePorCpf, ObterClientePorId obterClientePorId, ObterTodosOsClientes obterTodosOsClientes, ValidarCliente validarCliente) {
        this.atualizarCliente = atualizarCliente;
        this.cadastrarCliente = cadastrarCliente;
        this.excluirCliente = excluirCliente;
        this.obterClientePorCpf = obterClientePorCpf;
        this.obterClientePorId = obterClientePorId;
        this.obterTodosOsClientes = obterTodosOsClientes;
        this.validarCliente = validarCliente;
    }

    @PutMapping
    @Operation(summary = "Atualizar Cliente", description = "Altera os dados de um cliente existente.")
    public ClienteDTO atualizarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = atualizarCliente.atualizarCliente(new Cliente(dto.id(), dto.nome(), dto.cpf(), dto.email(), dto.senha()));
        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getEmail(), salvo.getSenha());
    }

    @PostMapping
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um novo cliente.")
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = cadastrarCliente.cadastrarCliente(new Cliente(dto.nome(), dto.cpf(), dto.email(), dto.senha()));
        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getEmail(), salvo.getSenha());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir Cliente", description = "Exclui um cliente.")
    public void excluirCliente(@PathVariable Long id) {
        excluirCliente.excluirCliente(id);
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Consultar Cliente por CPF", description = "Consulta um cliente à partir de um CPF.")
    public ClienteDTO obterClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = obterClientePorCpf.obterClientePorCpf(cpf);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getSenha());

    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Consultar Cliente por ID", description = "Consulta um cliente à partir de um ID.")
    public ClienteDTO obterClientePorId(@PathVariable Long id) {
        Cliente cliente = obterClientePorId.obterClientePorId(id);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getSenha());
    }

    @GetMapping
    @Operation(summary = "Listar Todos Clientes", description = "Lista todos os clientes registrados.")
    public List<ClienteDTO> obterTodosOsClientes() {
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        obterTodosOsClientes.obterTodosOsClientes().forEach(v -> clientesDTO.add(new ClienteDTO(
                v.getId(),
                v.getNome(),
                v.getCpf(),
                v.getEmail(),
                v.getSenha())));
        return clientesDTO;
    }

    @GetMapping("/consultar/{id}")
    @Operation(summary = "Validar Cliente", description = "Valida a existência de um cliente.")
    public Boolean validarCliente(@PathVariable Long id) {
        return validarCliente.validarCliente(id);
    }
}
