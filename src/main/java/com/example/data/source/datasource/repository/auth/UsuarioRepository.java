package com.example.data.source.datasource.repository.auth;

import com.example.data.source.datasource.model.auth.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
