package com.dsg.desguambios.entidades;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component
@SessionScope
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;
	
	
	
	private ArrayList<Producto> listaFavoritos;
	
	public Usuario() {
		listaFavoritos = new ArrayList<>();
	}
	
	
	public void aniadirALaLista(Producto p) {
		listaFavoritos.add(p);
	}
	
	public ArrayList<Producto> sacarLaLista() {
		return listaFavoritos;
	}
	
	public ArrayList<String> lista(){
		ArrayList<String> r = new ArrayList<String>();
		for (Producto p : listaFavoritos) {
			String n;
			n = p.getLitProducto();
			r.add(n);
		}
		
		return r;
	}
}