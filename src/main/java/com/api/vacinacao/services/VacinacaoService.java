package com.api.vacinacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.vacinacao.models.Vacinacao;
import com.api.vacinacao.repositories.VacinacaoRepository;

@Service
@Transactional
@ComponentScan("com.api.vacinacao.repositories")
public class VacinacaoService {

	@Autowired
	private VacinacaoRepository repositorio;
	
	public VacinacaoRepository getRepo() {
		VacinacaoRepository repo = repositorio;
		return repo;
	}
	
	public List<Vacinacao> getVacinacoes() {
		return getRepo().findAll();
	}
	
	public Long inserirVacinacao(Vacinacao vacinacao) {
		return getRepo().save(vacinacao).getId();
	}
}
