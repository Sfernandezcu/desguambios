package com.dsg.desguambios.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	
	private String litProducto;
	private String dir_empresa;
	private String usuario;
	private int id_marca;

	public Producto () {}
	
	public Producto (String litProducto, String dir_empresa, String usuario, Integer id_marca) {
		this.litProducto=litProducto;
		this.dir_empresa=dir_empresa;
		this.usuario=usuario;
		this.id_marca=id_marca;
	}
	
	
	public String getLitProducto () {
		return litProducto;
		
	}
	
	public void setLitProducto (String litProducto) {
		this.litProducto = litProducto;
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
	
	

	@Override
	public String toString() {
		return "Producto [id_producto=" + idProducto + ", litProducto=" + litProducto + ", dir_empresa="
				+ dir_empresa + ", usuario=" + usuario + ", id_marca=" + id_marca + "]";
	}
	
	
}
