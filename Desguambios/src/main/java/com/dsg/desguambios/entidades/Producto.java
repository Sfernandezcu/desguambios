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
	
	
	public Producto(long idProducto, String litProducto, String dirEmpresa, String usuario, String idMarca,
			List<Imagen> imagenes, Comentario comentario) {
		super();
		this.idProducto = idProducto;
		this.litProducto = litProducto;
		this.dirEmpresa = dirEmpresa;
		this.usuario = usuario;
		this.idMarca = idMarca;
		Imagenes = imagenes;
		this.comentario = comentario;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

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
		return "Producto [idProducto=" + idProducto + ", litProducto=" + litProducto + ", dirEmpresa=" + dirEmpresa
				+ ", usuario=" + usuario + ", idMarca=" + idMarca + ", Imagenes=" + Imagenes + ", comentario="
				+ comentario + "]";
	}
	
	
}
