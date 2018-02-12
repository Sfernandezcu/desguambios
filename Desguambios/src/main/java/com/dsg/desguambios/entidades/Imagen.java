package com.dsg.desguambios.entidades;



//@Entity
public class Imagen {

	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long idImagen;
	
	
	
	

	private String url;
	private int id_producto;
	
	protected Imagen () {}
	
	public Imagen (String url, Integer id_producto) {
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
		return "Imagen [id_imagen=" + idImagen + ", url=" + url + ", id_producto=" + id_producto + "]";
	}
	
	
}
