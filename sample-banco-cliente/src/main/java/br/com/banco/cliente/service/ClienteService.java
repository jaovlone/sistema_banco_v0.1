package br.com.banco.cliente.service;

import br.com.banco.cliente.domain.Cliente;
import br.com.banco.cliente.dto.ClienteRequest;
import br.com.banco.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteRequest request) {

        if (repository.existsByCpf(request.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        Cliente cliente = new Cliente();

        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());

        return repository.save(cliente);
    }
}