package com.biolab.seguranca.controllers;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClientesController {
    private final ClienteService service;
    public ClientesController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(service.criarCliente(dto));
    }

    @GetMapping
    public ResponseEntity<?> ola(){
        return ResponseEntity.ok("Ola");
    }
}
