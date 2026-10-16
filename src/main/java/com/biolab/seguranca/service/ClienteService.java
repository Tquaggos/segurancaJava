package com.biolab.seguranca.service;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.entity.Cliente;
import com.biolab.seguranca.entity.Role;
import com.biolab.seguranca.repository.ClienteRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository repo;

    public ClienteService(PasswordEncoder passwordEncoder, ClienteRepository repo) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }


    public Cliente criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        if (dto.getRole() == null) {
            cliente.setRole(Role.ROLE_USER);
        } else {
            cliente.setRole(dto.getRole());
        }
        repo.save(cliente);
        return cliente;

    }
}
