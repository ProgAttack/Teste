package com.gkramer.vendas.entities;

import java.math.BigDecimal;

public class VendedorOutput {
	
	
	private String name;
	private int totalVendas;
	private double mediaVendas;
	
	
	
	
	public VendedorOutput(String name, int totalVendas, double mediaVendas) {
		
		this.name = name;
		this.totalVendas = totalVendas;
		this.mediaVendas = mediaVendas;
		
		
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getTotalVendas() {
		return totalVendas;
	}




	public void setTotalVendas(int totalVendas) {
		this.totalVendas = totalVendas;
	}




	public double getMediaVendas() {
		return mediaVendas;
	}




	public void setMediaVendas(double mediaVendas) {
		this.mediaVendas = mediaVendas;
	}
	
	
	
	
	
	




	
}
