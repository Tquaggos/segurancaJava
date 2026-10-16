package com.biolab.seguranca.repository;

import com.biolab.seguranca.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {


    Cliente findByEmail(String email);
}
