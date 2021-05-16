package com.api.vacinacao.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.vacinacao.models.Usuario;
import com.api.vacinacao.models.Vacinacao;
import com.api.vacinacao.services.UsuarioService;
import com.api.vacinacao.services.VacinacaoService;

@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private VacinacaoService vacinaService;
	
	@PostMapping("/salvar")
	public ResponseEntity registraVacinacao(@RequestBody @Valid Vacinacao vacinacao, BindingResult result) {
		try {
			if(usuarioService.getRepo().findByEmail(vacinacao.getEmailUsuario()).size()==0) {
				return ResponseEntity.badRequest().body("Usuário não encontrado, cadastre um email válido");
			}
			vacinaService.getRepo().save(vacinacao);
			return ResponseEntity.created(null).build();
		} catch (Exception e) {
			if(result.hasErrors()) {
				return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
			} else {
				return ResponseEntity.badRequest().body("Erro ao registrar vacinação, favor verificar os dados.");				
			}
		}
	}
	
	@GetMapping("/listar")
	public List<Vacinacao> getVacinacoes() {
		List<Vacinacao> vacinas = vacinaService.getRepo().findAll();
		return vacinas;
	}
}
