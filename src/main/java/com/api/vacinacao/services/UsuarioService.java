package com.api.vacinacao.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.vacinacao.models.Usuario;
import com.api.vacinacao.repositories.UsuarioRepository;

@Service
@Transactional
@ComponentScan("com.api.vacinacao.repositories")
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public UsuarioRepository getRepo() {
		UsuarioRepository repo = repositorio;
		return repo;
	}
	
	public List<Usuario> getUsuarios() {
		return getRepo().findAll();
	}
	
	public Long inserirUsuario(Usuario usuario) {
		return getRepo().save(usuario).getId();
	}
}
