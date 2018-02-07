package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DesguambiosController {
		
		public ArrayList<Desguace> lista = new ArrayList<>();
		public ArrayList<Pieza> listaPiezas = new ArrayList<>();
		Pieza pieza_A= new Pieza("a","a","a","a","a");
		Pieza pieza_B= new Pieza("b","b,","b","b,","b");
		
		
		
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


