package com.loja.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.loja.api.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCPF(String cpf);
    Optional<Usuario> findByEmail(String email);
}