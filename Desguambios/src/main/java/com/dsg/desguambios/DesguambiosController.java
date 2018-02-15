package com.dsg.desguambios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.entidades.Usuario;
import com.dsg.desguambios.entidades.Comentario;
import com.dsg.desguambios.repositorios.DesguaceRepository;
import com.dsg.desguambios.repositorios.ProductoRepository;
import com.dsg.desguambios.repositorios.ComentarioRepository;




@Controller
public class DesguambiosController {
		
		//public ArrayList<Desguace> lista = new ArrayList<>();
		
		
	
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
		
		
		/**
		@PostConstruct
		public void init() {
			Comentario comentario = new Comentario("Hola");
			Desguace desguacePepe = new Desguace("Pepe","pepe@gmail.com","Calle epep 123","pepe","pepe");
			Producto Producto_A= new Producto("Retrovisor","Calle epep 123","Pepe","Bmw",comentario);
			Producto Producto_B= new Producto("Luna","Calle epep 123","Pepe","Mercedes",comentario);
			Producto Producto_C= new Producto("Puerta","Calle epep 123","Pepe","Renault",comentario);
			
			Desguace desguaceLuis = new Desguace("Luis","pepe@gmail.com","Calle siul 123","luis","luis");
			Producto Producto_D= new Producto("Retrovisor","Calle siul 123","Luis","Citroen",comentario);
			Producto Producto_E= new Producto("Luna","Calle siul 123","Luis","Audi",comentario);
			Producto Producto_F= new Producto("Puerta","Calle siul 123","Luis","Opel",comentario);
			
			desguaceRepository.save(desguacePepe);
			productoRepository.save(Producto_A);
			productoRepository.save(Producto_B);
			productoRepository.save(Producto_C);
			
			desguaceRepository.save(desguaceLuis);
			productoRepository.save(Producto_D);
			productoRepository.save(Producto_E);
			productoRepository.save(Producto_F);
			
			//listaProductos.add(Producto_A);
			//listaProductos.add(Producto_B);
			//lista.add(desguacePepe);
		}
		**/
		

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
			
			//listaFavoritos.add(Producto_A);
			//listaProductos.add(Producto_A);
			//listaProductos.add(Producto_B);
			//lista.add(desguacePepe);
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
		
		/*
		public Desguace buscarDes(String usuario) {
			Desguace d = new Desguace();
			
			for(Desguace ds : lista) {
				if(ds.getUsuario().equals(usuario)) {
					d = ds;
				}
			}		
			
			return d;
		}
		}*/
		
		@RequestMapping("/datosAlHacerLogin")
		public String datosAlHacerLogin(Model model,@RequestParam String usuario,@RequestParam String password){
			instanciaDesguace =desguaceRepository.findByUsuario(usuario);
			if(instanciaDesguace.getUsuario().equals(usuario)&& instanciaDesguace.getPassword().equals(password)) {
				return "subirEliminarEditar";
			}else {
				return "index";
			}
			
		}
		
	
		@RequestMapping("/login")
		public String weblogin(Model model) {
			
			return "login";
		}
		
		@RequestMapping(value = "/nuevoRegistro")
		public String nuevoRegistro(Model model) {
			
			return "registro";
		}
		@RequestMapping(value = "/subirEliminarEditar")
		public String subirEliminarEditar(Model model) {
			
			return "subirEliminarEditar";
		}
		
		
		@RequestMapping(value = "/subirProducto")
		public String subirProducto1(Model model) {
			
			model.addAttribute("nombredesguacepropietario",instanciaDesguace.getUsuario());
			model.addAttribute("direccionpropietario",instanciaDesguace.getDireccion());
			return "subirProducto";
		}
		
		@RequestMapping(value = "/subirNuevoProducto")
		public String subirNuevoProducto(Model model,@RequestParam String litProducto,@RequestParam String direccionpropietario,@RequestParam String nombredesguacepropietario,@RequestParam String id_marca,@RequestParam String contenido) {
			//int nM = Integer.parseInt(id_marca);
			Comentario comentario = new Comentario (contenido);
			comentarioRepository.save(comentario);
			Producto producto = new Producto (litProducto, direccionpropietario,  nombredesguacepropietario, id_marca, comentario);
			productoRepository.save(producto);
			//listaProductos.add(producto);
			//listaProductos.add(Producto_A);
			String usuario=instanciaDesguace.getUsuario();
			List<Producto> listaProductos=(List<Producto>) productoRepository.findByUsuario(usuario);
			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
	
		}
		
		
		
		@RequestMapping(value = "/verMisProductos")
		public String verMisProducto(Model model) {
			String usuario=instanciaDesguace.getUsuario();
			List<Producto> listaProductos=(List<Producto>) productoRepository.findByUsuario(usuario);
			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
		}
		
		
		@RequestMapping(value = "/editarProducto")
		public String vistaEditarProducto(Model model) {
			
			return "buscadorEditarProducto";
		}
		
		//Falta por hacer con base de datos
		@RequestMapping(value = "/subirProductoEditado")
		public String subirProductoEditado(Model model,@RequestParam String litProducto,@RequestParam String direccionpropietario,@RequestParam String nombredesguacepropietario,@RequestParam String id_marca,@RequestParam String contenido) {
			//int nM = Integer.parseInt(id_marca);
			Comentario comentario = new Comentario (contenido);
			comentarioRepository.save(comentario);
			Producto producto = new Producto ( litProducto,  direccionpropietario,  nombredesguacepropietario,id_marca, comentario);
			productoRepository.save(producto);
			//listaProductos.add(producto);
			//listaProductos.add(Producto_A);
			String usuario=instanciaDesguace.getUsuario();
			List<Producto> listaProductos=(List<Producto>) productoRepository.findByUsuario(usuario);
			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
		}
		
		//Falta por hacer con base de datos
		public Producto buscarP(String idProducto) {
			Producto p= new Producto();
			for(Producto producto : listaProductos) {
				if(producto.getLitProducto().equals(idProducto)) {
				   p=producto;
					
				}
			}
			return p;
		}
		//Hecho con base de datos, falta por informar al usuario el identificador de la pieza que esta subiendo
		@RequestMapping(value = "/datosEditarProducto")
		public String datosEditarProducto(Model model,@RequestParam Long idProducto) {
			
			//Producto producto;
			//producto = buscarP(idProducto);
			Producto producto=productoRepository.findByIdProducto(idProducto);
			if(producto!=null) {
			model.addAttribute("litProducto",producto.getLitProducto());
			model.addAttribute("id_marca",producto.getIdMarca());
			model.addAttribute("nombredesguacepropietario",producto.getUsuario());
			model.addAttribute("direccionpropietario",producto.getDirEmpresa());
			model.addAttribute("contenido",producto.getComentario());
			//listaProductos.remove(producto);
			productoRepository.delete(producto);
			return "editarProducto";
			}
			else {
				return vistaEditarProducto(model);
			}
		}
		
		
		
		 @RequestMapping(value = "/registro")
		 public String registro(Model model,@RequestParam String alta, String usuario,String email,
				  String direccion,  String password,  String valPassword) {
			
			if(Integer.parseInt(alta)==1) {
				Desguace instanciaDesguace = new Desguace(usuario,email,direccion,password,valPassword);
				desguaceRepository.save(instanciaDesguace);
				//lista.add(desguace);
				//lista.add(desguace1);
				model.addAttribute("mensaje", true);
				
			} else {
				model.addAttribute("mensaje", false);
			}
			 
			return "registro";
				 
			 
		 } 
		 
		 @RequestMapping(value = "/eliminarProducto")
			public String vistaEliminarProducto(Model model) {
				
				return "buscadorEliminarProducto";
			}
		 
		 

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
		 
		 
			@RequestMapping(value = "/datosEliminarProducto")
			public String datosEliminarProducto(Model model,@RequestParam Long idProducto) {
				
				//Producto producto;
				//producto = buscarP(idProducto);
				Producto producto=productoRepository.findByIdProducto(idProducto);
				//listaProductos.remove(producto);
				if(producto!=null) {
					productoRepository.delete(producto);
					System.out.println("La pieza con idproducto " +idProducto+ " se ha eliminado");
					return vistaEliminarProducto(model);
				}
				else {
					System.out.println("No hay una pieza con el idproducto=" +idProducto );
					return vistaEliminarProducto(model);
				}
				
			
			}
			/**
			@RequestMapping(value = "/comentario")
			public String comentario(Model model) {
				
				return "crearComentario";
			}
			
			
			@RequestMapping(value = "/subirNuevoComentario")
			public String subirNuevoComentario(Model model,@RequestParam String contenido) {
				Comentario comentario = new Comentario (contenido);
				ComentarioRepository.save(comentario);
				String producto=instanciaProducto.getidProducto();
				Producto Prudcto= ProductoRepository.findByComentario(comentario);
				model.addAttribute("listaComentarios",listaComentarios);
				return "verMisProductos";
		
			}
				/*
		 @RequestMapping(value = "/prueba")
		 public String registro(Model model) {
			
			 model.addAttribute("usuario", lista.get(0).getUsuario());
			 model.addAttribute("direccion", lista.get(0).getDireccion());
			 model.addAttribute("password", lista.get(0).getPassword());
			 model.addAttribute("email", lista.get(0).getEmail());
			 model.addAttribute("valPassword", lista.get(0).getValPassword());
			 
			 model.addAttribute("usuario1", lista.get(1).getUsuario());
			 model.addAttribute("direccion1", lista.get(1).getDireccion());
			 model.addAttribute("password1", lista.get(1).getPassword());
			 model.addAttribute("email1", lista.get(1).getEmail());
			 model.addAttribute("valPassword1", lista.get(1).getValPassword());

			 
			 
			return "prueba";
			 
			 
			 
		 }		*/ 
		 
		 
		 
	}