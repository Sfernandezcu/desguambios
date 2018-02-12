package com.dsg.desguambios;

public class Pieza {
	
	private String literalDelProducto;
	private String idDelProducto;
	private String idDeLaMarca;
	
	private String desguacepropietario;
	private String direccionDelDesguace;
	
	public Pieza() {
		
	}
	
	public Pieza(String literalDelProducto, String idDelProducto, String idDeLaMarca, String desguacepropietario,
			String direccionDelDesguace) {
		
		this.literalDelProducto = literalDelProducto;
		this.idDelProducto = idDelProducto;
		this.idDeLaMarca = idDeLaMarca;
		this.desguacepropietario = desguacepropietario;
		this.direccionDelDesguace = direccionDelDesguace;
	}
	
	public String getLiteralDelProducto() {
		return literalDelProducto;
	}
	public void setLiteralDelProducto(String literalDelProducto) {
		this.literalDelProducto = literalDelProducto;
	}
	public String getIdDelProducto() {
		return idDelProducto;
	}
	public void setIdDelProducto(String idDelProducto) {
		this.idDelProducto = idDelProducto;
	}
	public String getIdDeLaMarca() {
		return idDeLaMarca;
	}
	public void setIdDeLaMarca(String idDeLaMarca) {
		this.idDeLaMarca = idDeLaMarca;
	}
	public String getDesguacepropietario() {
		return desguacepropietario;
	}
	public void setDesguacepropietario(String desguacepropietario) {
		this.desguacepropietario = desguacepropietario;
	}
	public String getDireccionDelDesguace() {
		return direccionDelDesguace;
	}
	public void setDireccionDelDesguace(String direccionDelDesguace) {
		this.direccionDelDesguace = direccionDelDesguace;
	}
	
	@Override
	public String toString() {
		return "Pieza [literalDelProducto=" + literalDelProducto + ", idDelProducto=" + idDelProducto + ", idDeLaMarca="
				+ idDeLaMarca + ", desguacepropietario=" + desguacepropietario + ", direccionDelDesguace="
				+ direccionDelDesguace + "]";
	}
	
	
	
	
	
	
}
