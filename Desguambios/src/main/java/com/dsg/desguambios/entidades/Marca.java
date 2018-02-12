package com.dsg.desguambios.entidades;



//@Entity
public class Marca {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMarca;
	
	
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
		return "Marca [idMarca=" + idMarca + ", Marca del coche=" + lit_marca + "]";
	}
	
}
