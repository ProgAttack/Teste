package com.gkramer.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gkramer.vendas.entities.Vendas;

public interface VendasRepositorio extends JpaRepository<Vendas, Long>{

}
