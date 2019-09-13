package com.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_rest.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
