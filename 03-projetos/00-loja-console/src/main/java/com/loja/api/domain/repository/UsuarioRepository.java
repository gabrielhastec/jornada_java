package com.loja.api.domain.repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCPF(String cpf);
    Optional<Usuario> findByEmail(String email);
}