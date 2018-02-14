package com.dsg.desguambios.entidades;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component
@SessionScope
public class Usuario {
	
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
}