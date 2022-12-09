package com.mercadolivre.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.apirest.models.Produto;
import com.mercadolivre.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping (value="/api")
@Api(value="API REST Produtos")
@CrossOrigin (origins="*")
public class ProdutoResource {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping ("/produtos")
	@ApiOperation (value = "Retorna uma lista de todos os produtos do banco de dados")
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping ("/produtos/{id}")
	@ApiOperation (value = "Retorna um produto pelo ID do banco de dados")
	public Produto listarProdutosId(@PathVariable (value = "id")long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping ("/produto")
	@ApiOperation (value = "Cadastra um novo produto no banco de dados")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping ("/produtos")
	@ApiOperation (value = "Deleta um  produto no banco de dados")
	public void deletarProdutos(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping ("/produtos")
	@ApiOperation (value = "Atualiza um  produto no banco de dados")
	public Produto atualizarProdutos(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
}

//Esta classe que vai receber as requisições http