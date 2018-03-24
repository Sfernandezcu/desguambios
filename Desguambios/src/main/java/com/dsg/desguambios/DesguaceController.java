package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DesguaceController {

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
	
			
			
			@RequestMapping(value = "/subirEliminarEditar")
			public String subirEliminarEditar(Model model) {
				
				return "subirEliminarEditar";
			}
			
			
			
			@RequestMapping(value = "/subirProducto")
			public String subirProducto1(Model model,HttpServletRequest request) {
				instanciaDesguace = desguaceRepository.findByUsuario(request.getUserPrincipal().getName());
				
				model.addAttribute("nombredesguacepropietario",instanciaDesguace.getUsuario());
				model.addAttribute("direccionpropietario",instanciaDesguace.getDireccion());
				return "subirProducto";
			}
			
			
			@RequestMapping(value = "/subirNuevoProducto")
			public String subirNuevoProducto(Model model,@RequestParam String litProducto,@RequestParam String direccionpropietario,@RequestParam String nombredesguacepropietario,@RequestParam String id_marca,@RequestParam String contenido,HttpServletRequest request) {
				
				instanciaDesguace = desguaceRepository.findByUsuario(request.getUserPrincipal().getName());
				if(contenido == null) {
					contenido = "";
				}
				
				Comentario comentario = new Comentario (contenido);
				comentarioRepository.save(comentario);
				
				Producto producto = new Producto (litProducto, direccionpropietario,  nombredesguacepropietario, id_marca, comentario);
				productoRepository.save(producto);
				
				String usuario=instanciaDesguace.getUsuario();
				List<Producto> listaProductos=(List<Producto>) productoRepository.findByUsuario(usuario);
				model.addAttribute("listaProductos",listaProductos);
				return "verMisProductos";
		
			}
			
			
			
			@RequestMapping(value = "/verMisProductos")
			public String verMisProducto(Model model,HttpServletRequest request) {
				
				instanciaDesguace = desguaceRepository.findByUsuario(request.getUserPrincipal().getName());
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
			public String subirProductoEditado(Model model,HttpServletRequest request,@RequestParam Long idProducto,@RequestParam String litProducto,@RequestParam String direccionpropietario,
					@RequestParam String nombredesguacepropietario,@RequestParam String id_marca,@RequestParam String contenido) {
				
				Producto producto = productoRepository.findByIdProducto(idProducto);
				
				if(producto.getComentario() == null) {
					Comentario comentario = new Comentario (contenido);				
					comentarioRepository.save(comentario);				
					productoRepository.updateProducto2(litProducto, direccionpropietario, nombredesguacepropietario, id_marca,comentario,idProducto);
					
				}else {
					long comentario_id_comentario = producto.getComentario().getIdComentario();
					productoRepository.updateProducto(litProducto, direccionpropietario, nombredesguacepropietario, id_marca, idProducto);
					comentarioRepository.updateComentario(contenido, comentario_id_comentario);
				
				}
				
				
				
				verMisProducto(model,request);
			
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
				model.addAttribute("idProducto",producto.getIdProducto());
				
				//listaProductos.remove(producto);
				//--------------------------------productoRepository.delete(producto);
				return "editarProducto";
				}
				else {
					return vistaEditarProducto(model);
				}
			}
			
			
			
			 @RequestMapping(value = "/eliminarProducto")
				public String vistaEliminarProducto(Model model) {
					
					return "buscadorEliminarProducto";
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
			 
			 
			 
}
