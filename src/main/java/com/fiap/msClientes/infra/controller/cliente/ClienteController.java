package com.fiap.msClientes.infra.controller.cliente;

import com.fiap.msClientes.application.usecases.cliente.*;
import com.fiap.msClientes.entities.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final AtualizarCliente atualizarCliente;
    private final CadastrarCliente cadastrarCliente;
    private final ExcluirCliente excluirCliente;
    private final ObterClientePorCpf obterClientePorCpf;
    private final ObterClientePorId obterClientePorId;
    private final ObterTodosOsClientes obterTodosOsClientes;

    public ClienteController(AtualizarCliente atualizarCliente, CadastrarCliente cadastrarCliente, ExcluirCliente excluirCliente, ObterClientePorCpf obterClientePorCpf, ObterClientePorId obterClientePorId, ObterTodosOsClientes obterTodosOsClientes) {
        this.atualizarCliente = atualizarCliente;
        this.cadastrarCliente = cadastrarCliente;
        this.excluirCliente = excluirCliente;
        this.obterClientePorCpf = obterClientePorCpf;
        this.obterClientePorId = obterClientePorId;
        this.obterTodosOsClientes = obterTodosOsClientes;
    }

    @PutMapping
    public ClienteDTO atualizarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = atualizarCliente.atualizarCliente(new Cliente(dto.id(), dto.nome(), dto.cpf(), dto.email(), dto.senha()));
        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getEmail(), salvo.getSenha());
    }

    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = cadastrarCliente.cadastrarCliente(new Cliente(dto.nome(), dto.cpf(), dto.email(), dto.senha()));
        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getEmail(), salvo.getSenha());
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        excluirCliente.excluirCliente(id);
    }

    @GetMapping("/cpf/{cpf}")
    public ClienteDTO obterClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = obterClientePorCpf.obterClientePorCpf(cpf);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getSenha());

    }

    @GetMapping("/id/{id}")
    public ClienteDTO obterClientePorId(@PathVariable Long id) {
        Cliente cliente = obterClientePorId.obterClientePorId(id);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getSenha());
    }

    @GetMapping
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
}
