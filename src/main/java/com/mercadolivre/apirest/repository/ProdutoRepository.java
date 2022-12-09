package com.mercadolivre.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolivre.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	//<Produto /*Entidade*/,Long /* Tipo de dados do Id*/>
	Produto findById(long id);
	
}
