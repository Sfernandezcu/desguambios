package com.dsg.desguambios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.entidades.Usuario;
import com.dsg.desguambios.repositorios.ComentarioRepository;
import com.dsg.desguambios.repositorios.DesguaceRepository;
import com.dsg.desguambios.repositorios.ProductoRepository;


@Controller
public class LoginController {
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
	
	/*
	@RequestMapping("/datosAlHacerLogin")
	public String datosAlHacerLogin(Model model,@RequestParam String usuario,@RequestParam String password){
		instanciaDesguace =desguaceRepository.findByUsuario(usuario);
		if(instanciaDesguace.getUsuario().equals(usuario)&& instanciaDesguace.getPassword().equals(password)) {
			return "subirEliminarEditar";
		}else {
			return "index";
		}
		
	}*/
	

	@RequestMapping("/login")
	public String weblogin(Model model) {
		return "login";
	}
	
	@GetMapping("/loginError")
    public String loginerror() {
    	return "loginError";
    }
			 
			 
}
