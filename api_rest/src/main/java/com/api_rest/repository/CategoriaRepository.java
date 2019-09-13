package com.api_rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_rest.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	void save(Optional<Categoria> categoriaSalva);



}
