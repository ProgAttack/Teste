package com.gkramer.vendas.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkramer.vendas.entities.Vendas;
import com.gkramer.vendas.entities.Vendedor;
import com.gkramer.vendas.repositories.VendasRepositorio;
import com.gkramer.vendas.repositories.VendedorRepositorio;

import jakarta.validation.Valid;

@RequestMapping(value = "/vendas")
@RestController

public class VendasControladores {
	
	@Autowired
	private VendasRepositorio repositorio;
	@Autowired
	private VendedorRepositorio repositoriovendedor;
	
	
	@GetMapping
	public List<Vendas> findAll(){
		
		List<Vendas> resultado = repositorio.findAll();
		return resultado;
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vendas> findById(@PathVariable Long id){
		try {
			Vendas resultado = repositorio.findById(id).get();
			return ResponseEntity.ok(resultado);
		} catch (Exception e) {
			return new ResponseEntity("Não encontrado", HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity<Vendas> insert(@Valid @RequestBody Vendas vendas){
		
		try {
			Vendedor vendedor = repositoriovendedor.findById(vendas.getVendedor().getId()).get();
			//verificar se vendedor existe
			
		} catch (Exception e) {
			return new ResponseEntity("Vendedor não encontrado", HttpStatus.NOT_FOUND);
		}
		
		Vendas resultado = repositorio.save(vendas);
		 return ResponseEntity.ok(resultado);
		
	}
	
	

}
