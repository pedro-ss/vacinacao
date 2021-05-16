package com.api.vacinacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.vacinacao.models.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByEmail(String email);
}
