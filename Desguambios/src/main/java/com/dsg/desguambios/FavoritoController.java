package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.entidades.Usuario;
import com.dsg.desguambios.repositorios.ProductoRepository;

public class FavoritoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired 
	Usuario usuario;

	@GetMapping("/favoritos/{idProducto}")
	public String guardarFavorito(Model model, @PathVariable Long idProducto) {
		Producto p = new Producto();
		p=productoRepository.findByIdProducto(idProducto);
		usuario.aniadirALaLista(p);
		return "guardadoFavorito";
	}
	
	@RequestMapping("/favoritos")
	public String delvolverFavoritos(Model model) {
		model.addAttribute("listaFavoritos", usuario.sacarLaLista());
		return "resultadoFavoritos";
	}
	 
	 
}
