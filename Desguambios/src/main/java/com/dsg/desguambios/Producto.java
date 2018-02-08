package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_producto;
	
	
	private String lit_producto;
	private String dir_empresa;
	private String usuario;
	private Integer id_marca;

	protected Producto () {}
	
	public Producto (String lit_producto, String dir_empresa, String usuario, Integer id_marca) {
		this.lit_producto=lit_producto;
		this.dir_empresa=dir_empresa;
		this.usuario=usuario;
		this.id_marca=id_marca;
	}
	
	
	public String getLitProducto () {
		return lit_producto;
		
	}
	
	public void setLitProducto (String lit_producto) {
		this.lit_producto = lit_producto;
	}
	
	public String getDirEmpresa () {
		return dir_empresa;
	}
	
	public void setDirEmpresa (String dir_empresa) {
		this.dir_empresa = dir_empresa;
	}
	
	public String getUsuario () {
		return usuario;
	}
	
	public void setUsuario (String usuario) {
		this.usuario = usuario;
	}
	
	public Integer getIdMarca () {
		return id_marca;
	}
	
	public void setIdMarca (Integer id_marca) {
		this.id_marca = id_marca;
	}
	
	
	
}
