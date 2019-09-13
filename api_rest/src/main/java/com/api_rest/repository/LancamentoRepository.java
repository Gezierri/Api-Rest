package com.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_rest.entities.Lancamento;
import com.api_rest.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
