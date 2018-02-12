package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;

@Controller
public class DesguambiosController {
		
		public ArrayList<Desguace> lista = new ArrayList<>();
		public ArrayList<Producto> listaProductos = new ArrayList<>();
		Producto Producto_A= new Producto("a","a","a",1);
		Producto Producto_B= new Producto("b","b,","b",2);
		
		private Desguace desguacePepe = new Desguace("Pepe","pepe@gmail.com","Calle Falsa 123","pepe","pepe");
		
		@Autowired
		private Desguace instanciaDesguace = null;
		
		@PostConstruct
		public void aniadirProductos() {
			listaProductos.add(Producto_A);
			listaProductos.add(Producto_B);
			lista.add(desguacePepe);
		}
		
		@RequestMapping("/")
		public String webIndex(Model model) {
			return "index";
		}
		
		
		public Desguace buscarDes(String usuario) {
			Desguace d = new Desguace();
			
			for(Desguace ds : lista) {
				if(ds.getUsuario().equals(usuario)) {
					d = ds;
				}
			}		
			
			return d;
		}
		
		
		
		@RequestMapping("/datosAlHacerLogin")
		public String datosAlHacerLogin(Model model,@RequestParam String usuario,@RequestParam String password){
			Desguace user = new Desguace();
			user=buscarDes(usuario);
			if(user.getUsuario().equals(usuario)&& user.getPassword().equals(password)) {
				
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
			model.addAttribute("nombredesguacepropietario",desguacePepe.getUsuario());
			model.addAttribute("nombredireccionpropietario",desguacePepe.getDireccion());
			return "subirProducto";
		}
		
		@RequestMapping(value = "/subirNuevoProducto")
		public String subirNuevoProducto(Model model,@RequestParam String lit_producto,@RequestParam String dir_empresa,@RequestParam String usuario,@RequestParam String id_marca) {
			int nM = Integer.parseInt(id_marca);
			Producto Producto = new Producto ( lit_producto,  dir_empresa,  usuario,nM);
			listaProductos.add(Producto);
			listaProductos.add(Producto_A);
			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
		}
		
		@RequestMapping(value = "/verMisProductos")
		public String verMisProducto(Model model) {

			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
		}
		
		
		@RequestMapping(value = "/editarProducto")
		public String vistaEditarProducto(Model model) {
			
			return "buscadorEditarProducto";
		}
		
		
		@RequestMapping(value = "/subirProductoEditado")
		public String subirProductoEditado(Model model,@RequestParam String lit_producto,@RequestParam String dir_empresa,@RequestParam String usuario,@RequestParam String id_marca) {
			int nM = Integer.parseInt(id_marca);
			Producto Producto = new Producto ( lit_producto,  dir_empresa,  usuario,nM);
			listaProductos.add(Producto);
			model.addAttribute("listaProductos",listaProductos);
			return "verMisProductos";
		}
		
		
		public Producto buscarP(String idProducto) {
			Producto p= new Producto();
			for(Producto producto : listaProductos) {
				if(producto.getLitProducto().equals(idProducto)) {
				   p=producto;
					
				}
			}
			return p;
		}
		
		@RequestMapping(value = "/datosEditarProducto")
		public String datosEditarProducto(Model model,@RequestParam String idProducto) {
			
			
			Producto producto;
			producto = buscarP(idProducto);
			System.out.println(producto.toString());
			model.addAttribute("lit_producto",producto.getLitProducto());
			model.addAttribute("id_marca",producto.getIdMarca());
			model.addAttribute("nombredesguacepropietario",producto.getUsuario());
			model.addAttribute("nombredireccionpropietario",producto.getDirEmpresa());
			listaProductos.remove(producto);
			return "editarProducto";
		}
		
		
		
		 @RequestMapping(value = "/registro")
		 public String registro(Model model,@RequestParam String alta, String usuario,String email,
				  String direccion,  String password,  String valPassword) {
			
		
			if(Integer.parseInt(alta)==1) {
				Desguace desguace = new Desguace(usuario,email,direccion,password,valPassword);
				Desguace desguace1 = new Desguace("guiulle","guiulle","guiulle","guiulle","guiulle");
	
				lista.add(desguace);
				lista.add(desguace1);
	
				
				
				model.addAttribute("mensaje", true);
				
			} else {
				model.addAttribute("mensaje", false);
			}
			 
			return "registro";
				 
			 
		 } 
		 
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
			 
			 
			 
		 }		 
		 
		 
		 
	}