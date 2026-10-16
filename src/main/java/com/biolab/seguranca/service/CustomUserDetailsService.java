package com.biolab.seguranca.service;

import com.biolab.seguranca.entity.Cliente;
import com.biolab.seguranca.repository.ClienteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final ClienteRepository usuarioRepository;

    public CustomUserDetailsService(

            ClienteRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente usuario = usuarioRepository.findByEmail(email);
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name().replace("ROLE_",""))
                .build();
    }
}
