package com.dsg.desguambios.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Imagen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_imagen;
	
	
	
	

	private String url;
	private long id_producto;
	
	protected Imagen () {}
	
	public Imagen (String url, long id_producto) {
		this.url = url;
		this.id_producto = id_producto;
	}
	
	
	public String getUrl () {
		return url;
	}
	
	public void setUrl (String url) {
		this.url = url;
	}
	
	
	public long getIdProducto () {
		return id_producto;
	}
	
	public void setIdProducto (Integer id_producto) {
		this.id_producto = id_producto;
	}

	@Override
	public String toString() {
		return "Imagen [id_imagen=" + id_imagen + ", url=" + url + ", id_producto=" + id_producto + "]";
	}
	
	
}
