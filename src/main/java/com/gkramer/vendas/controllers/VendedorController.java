package com.gkramer.vendas.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkramer.vendas.entities.Vendedor;
import com.gkramer.vendas.entities.VendedorOutput;
import com.gkramer.vendas.repositories.VendasRepositorio;
import com.gkramer.vendas.repositories.VendedorRepositorio;


@RequestMapping(value = "/vendedor")
@RestController

public class VendedorController {
	
	@Autowired
	
	private VendasRepositorio repositorio; 
	
	@Autowired
	private VendedorRepositorio repositoriovendedor;
	
	
	
	@GetMapping
	public List<VendedorOutput> findAll(String data1, String data2){
		try {
			List<VendedorOutput> saida = new ArrayList<VendedorOutput>();
			Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(data1);
			Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(data2);
			
			long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
		    Long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			List<Vendedor> vendedores = repositoriovendedor.findAll();
			for(Vendedor vendedor : vendedores) {
				Integer count = repositorio.buscarVendasVendedorId(date1, date2, vendedor.getId());
				double mediaVendas = count.doubleValue() / diff.doubleValue();
				saida.add(new VendedorOutput(vendedor.getName(), count, mediaVendas));
				
			}

			return saida;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
		
		
		
	}
	
	
	
	


}
