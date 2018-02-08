package com.dsg.desguambios;

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
	
}
