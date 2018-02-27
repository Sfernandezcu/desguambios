package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.desguambios.entidades.Comentario;
import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.entidades.Usuario;
import com.dsg.desguambios.repositorios.ComentarioRepository;
import com.dsg.desguambios.repositorios.DesguaceRepository;
import com.dsg.desguambios.repositorios.ProductoRepository;


@Controller
public class IndexController {
	
	@Autowired
	private Desguace instanciaDesguace = null;
	@Autowired
	private DesguaceRepository desguaceRepository;
	@Autowired
	private ProductoRepository productoRepository;
	//@Autowired
	public List<Producto> listaProductos = new ArrayList<>();
	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired 
	Usuario usuario;
	
	@PostConstruct
	public void init() {
		
		
		Desguace desguacePepe = new Desguace("Pepe","pepe@gmail.com","Calle epep 123","pepe","pepe");
		Producto Producto_A= new Producto("Retrovisor","Calle epep 123","Pepe","Bmw");
		Producto Producto_B= new Producto("Luna","Calle epep 123","Pepe","Mercedes");
		Producto Producto_C= new Producto("Puerta","Calle epep 123","Pepe","Renault");
		
		Desguace desguaceLuis = new Desguace("Luis","pepe@gmail.com","Calle siul 123","luis","luis");
		Producto Producto_D= new Producto("Retrovisor","Calle siul 123","Luis","Citroen");
		Producto Producto_E= new Producto("Luna","Calle siul 123","Luis","Audi");
		Producto Producto_F= new Producto("Puerta","Calle siul 123","Luis","Opel");
		
		desguaceRepository.save(desguacePepe);
		productoRepository.save(Producto_A);
		productoRepository.save(Producto_B);
		productoRepository.save(Producto_C);
		
		desguaceRepository.save(desguaceLuis);
		productoRepository.save(Producto_D);
		productoRepository.save(Producto_E);
		productoRepository.save(Producto_F);
		
	}
	
	
	
	@RequestMapping("/")
	public String webIndex(Model model) {
		return "index";
	}
	
	
	
	//Buscador principal
	
	@RequestMapping(value ="/buscadorPrincipal")
	public String buscadorPrincipal(Model model, @RequestParam String idMarca, @RequestParam String litProducto) {
		
		List<Producto> listaProductos = new ArrayList<>();
					
		if((!idMarca.isEmpty()) && (!litProducto.isEmpty())){
			
		 listaProductos = productoRepository.findByLitProductoContainingIgnoreCaseAndIdMarcaContainingIgnoreCase(litProducto, idMarca);
		
		}else if((!idMarca.isEmpty()) && (litProducto.isEmpty())){
			 
			 listaProductos = productoRepository.findByIdMarcaIgnoreCase(idMarca);
			 
		}else if((idMarca.isEmpty())&&(!litProducto.isEmpty())) {
			
			listaProductos = productoRepository.findByLitProductoIgnoreCase(litProducto);
			 
			
		}else {
			 listaProductos = productoRepository.findAll(new Sort("idMarca"));

		}
		
		model.addAttribute("listaProductos",listaProductos);
		
		return "resultadoBuscador";
	}
}
