package com.gkramer.vendas.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkramer.vendas.entities.Vendas;
import com.gkramer.vendas.repositories.VendasRepositorio;

@RequestMapping(value = "/vendas")
@RestController

public class VendasControladores {
	
	@Autowired
	private VendasRepositorio repositorio;  
	
	
	@GetMapping
	public List<Vendas> findAll(){
		
		List<Vendas> resultado = repositorio.findAll();
		return resultado;
		
	}
	
	@GetMapping(value = "/{id}")
	public Vendas findById(@PathVariable Long id){
		
		Vendas resultado = repositorio.findById(id).get();
		return resultado;
		
	}
	
	@PostMapping
	public Vendas insert(@RequestBody Vendas vendas){
		
		Vendas resultado = repositorio.save(vendas);
		return resultado;
		
	}
	
	

}
