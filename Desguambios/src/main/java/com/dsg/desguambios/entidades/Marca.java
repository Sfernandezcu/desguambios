package com.dsg.desguambios.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_marca;
	
	
	private String lit_marca;
	
	protected Marca () {}
	
	
	public Marca (String lit_marca) {
		this.lit_marca = lit_marca;
	}
	
	
	public String getMarca () {
		return lit_marca;
	}
	
	public void setMarca (String lit_marca) {
		this.lit_marca = lit_marca;
	}
	
	@Override
	public String toString() {
		return "Marca [idMarca=" + id_marca + ", Marca del coche=" + lit_marca + "]";
	}
	
}
