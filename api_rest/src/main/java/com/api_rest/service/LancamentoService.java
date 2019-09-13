package com.api_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api_rest.entities.Lancamento;
import com.api_rest.entities.Pessoa;
import com.api_rest.repository.LancamentoRepository;
import com.api_rest.repository.PessoaRepository;
import com.api_rest.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		
		Pessoa pessoaSalva = pessoaRepository.getOne(lancamento.getPessoa().getCodigo());
		Pessoa pessoa = pessoaRepository.getOne(pessoaSalva.getCodigo());
		if (pessoaSalva.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		if (pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoRepository.save(lancamento);
	}	
}
