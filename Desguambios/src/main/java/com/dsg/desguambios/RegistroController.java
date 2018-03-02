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
public class RegistroController {
	//public ArrayList<Desguace> lista = new ArrayList<>();
	
	
	
			@Autowired
			private Desguace instanciaDesguace = null;
			@Autowired
			private DesguaceRepository desguaceRepository;
		
			
			@Autowired 
			Usuario usuario;
			
			
			
			
			
			
			
		
			
		
		
			
			@RequestMapping(value = "/nuevoRegistro")
			public String nuevoRegistro(Model model) {
				return "registro";
			}
			
			
			 @RequestMapping(value = "/registro")
			 public String registro(Model model,@RequestParam String alta, String usuario,String email,
					  String direccion,  String password, String valPassword) {
				
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
			 
			 
			 
}
