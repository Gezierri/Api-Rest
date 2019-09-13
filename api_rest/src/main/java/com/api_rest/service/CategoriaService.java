package com.api_rest.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api_rest.entities.Categoria;
import com.api_rest.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = buscarCodigo(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		categoriaRepository.save(categoriaSalva);
		return categoriaSalva;
	}

	private Categoria buscarCodigo(Long codigo) {
		Optional<Categoria> categoriaSalva = categoriaRepository.findById(codigo);
		if (!categoriaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaSalva.get();
	}
	
	

}
