package br.com.banco.cliente.repository;

import br.com.banco.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByEmail(String email);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}