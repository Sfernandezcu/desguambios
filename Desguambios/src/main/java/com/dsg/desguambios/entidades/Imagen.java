package com.dsg.desguambios.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity
public class Imagen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idImagen;
	

	private String url;
	private long idProducto;
	
	@ManyToOne
	private Producto producto;
	
	protected Imagen () {}
	
	public Imagen (String url, Long idProducto) {
		this.url = url;
		this.idProducto = idProducto;
	}
	
	
	public String getUrl () {
		return url;
	}
	
	public void setUrl (String url) {
		this.url = url;
	}
	
	
	public long getIdProducto () {
		return idProducto;
	}
	
	public void setIdProducto (Integer idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "Imagen [id_imagen=" + idImagen + ", url=" + url + ", idProducto=" + idProducto + "]";
	}
	
	
}
