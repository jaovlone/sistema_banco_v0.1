package br.com.banco.cliente.controller;

import br.com.banco.cliente.domain.Cliente;
import br.com.banco.cliente.dto.ClienteRequest;
import br.com.banco.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody @Valid ClienteRequest request) {
        return service.cadastrar(request);
    }
}