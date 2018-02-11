package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.desguambios.entidades.Cliente;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.repositorios.ClienteRepository;

@Controller
public class DesguambiosController {
		
		public ArrayList<Cliente> lista = new ArrayList<>();
		public ArrayList<Producto> listaPiezas = new ArrayList<>();
		Producto pieza_A= new Producto("","","",1);
		Producto pieza_B= new Producto("","","",2);
		
		//creado repositorio clientes
		
		//@Autowired
		//private  ClienteRepository repositorioClientes;
		
		
		
		
		public void aniadirPiezas() {
			listaPiezas.add(pieza_A);
			listaPiezas.add(pieza_B);
		}
		
		@RequestMapping ("/mostrarPiezas")
		public String iterarSobreLaListaDePiezas(Model model) {
			aniadirPiezas();
			model.addAttribute("listaPiezas",listaPiezas);
			
			return "mostrarPiezas";
		}
		
		@RequestMapping ("/subirPieza")
		public String subirPieza(Model model) {
			
			
			return "mostrarPiezas";
		}
		
		@RequestMapping("/")
		public String webIndex(Model model) {
			return "index";
		}
		
		@RequestMapping("/login")
		public String weblogin(Model model) {
			return "login";
		}
		
		 @RequestMapping(value = "/registro")
		 public String registro(Model model,@RequestParam String alta, String desguace,String email,
				  String direccion,  String password) {

			if(Integer.parseInt(alta)==1) {
				//añadir desguace al repositorio
				Cliente cliente = new Cliente(desguace,email,direccion,password);
				
				//repositorioClientes.save(cliente);
				
				
				model.addAttribute("mensaje", true);
				
			} else {
				model.addAttribute("mensaje", false);
			}
			 
			return "registro";
				 
			 
		 } 
		 
		 
		 @RequestMapping(value = "/prueba")
		 public String registro(Model model) {
			
			 model.addAttribute("usuario", lista.get(0).getDesguace());
			 model.addAttribute("direccion", lista.get(0).getDireccion());
			 model.addAttribute("password", lista.get(0).getPassword());
			 model.addAttribute("email", lista.get(0).getEmail());
			 
			 model.addAttribute("usuario1", lista.get(1).getDesguace());
			 model.addAttribute("direccion1", lista.get(1).getDireccion());
			 model.addAttribute("password1", lista.get(1).getPassword());
			 model.addAttribute("email1", lista.get(1).getEmail());

			 
			 
			return "prueba";
			 
			 
			 
		 }		 
		 
		 
		 
	}


