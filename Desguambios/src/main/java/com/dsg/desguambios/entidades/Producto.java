package com.dsg.desguambios.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	
	private String litProducto;
	private String dirEmpresa;
	private String usuario;
	private String idMarca;
	
	@OneToMany(mappedBy="producto")
	private List<Imagen> Imagenes;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Comentario comentario;
	
	
	public Producto () {}
	
	public Producto (String litProducto, String dir_empresa, String usuario, String id_marca) {
		this.litProducto=litProducto;
		this.dirEmpresa=dir_empresa;
		this.usuario=usuario;
		this.idMarca=id_marca;
	}
	
	
	public String getLitProducto () {
		return litProducto;
		
	}
	
	public void setLitProducto (String litProducto) {
		this.litProducto = litProducto;
	}
	
	public String getDirEmpresa () {
		return dirEmpresa;
	}
	
	public void setDirEmpresa (String dir_empresa) {
		this.dirEmpresa = dir_empresa;
	}
	
	public String getUsuario () {
		return usuario;
	}
	
	public void setUsuario (String usuario) {
		this.usuario = usuario;
	}
	
	public String getIdMarca () {
		return idMarca;
	}
	
	public void setIdMarca (String id_marca) {
		this.idMarca = id_marca;
	}
	
	

	@Override
	public String toString() {
		return "Producto [id_producto=" + idProducto + ", litProducto=" + litProducto + ", dir_empresa="
				+ dirEmpresa + ", usuario=" + usuario + ", id_marca=" + idMarca + "]";
	}
	
	
}
