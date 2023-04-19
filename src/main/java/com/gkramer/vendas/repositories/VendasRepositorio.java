package com.gkramer.vendas.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gkramer.vendas.entities.Vendas;
import com.gkramer.vendas.entities.Vendedor;



public interface VendasRepositorio extends JpaRepository<Vendas, Long>{
	@Query("Select distinct ven from Vendas ven "
			+ "Join fetch ven.vendedor vendedor "
			+ "Where ven.data between ?1 and ?2 ")
	List<Vendas> buscarIdVendas(Date datainicio, Date datafinal);
	
	@Query("Select count(ven) from Vendas ven "
			+ "Join ven.vendedor vendedor "
			+ "Where ven.data between ?1 and ?2 "
			+ "And vendedor.id = ?3")
	Integer buscarVendasVendedorId(Date datainicio, Date datafinal, Long vendedorid);
	
	


}


