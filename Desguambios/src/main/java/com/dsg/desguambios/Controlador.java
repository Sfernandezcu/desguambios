package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controlador {

	@Autowired
	 private UserService usersService;
	 private Formulario formulario;
	 
	 
	 
	 @PostMapping("/formulario")
	 public String registro(Model model, @RequestParam String usuario, @RequestParam String email,
			 @RequestParam String direccion, @RequestParam String password, @RequestParam String valPassword) {
		 
		 
		 formulario.setAll(usuario, email, direccion, password, valPassword);
		 
		 
		 if(password.equals(valPassword)) {
			 return "login";
		 }else {
			 
			 model.addAttribute("silent",true);
			 
			 return "formulario";
		 }
		 
		 
		 
	 }
	
	 @RequestMapping("/index")
	 public String greeting(Model model) {
	 model.addAttribute("name",
	 usersService.getNumUsers()+" users");

	 return "index";
	 }
	 
	 

	
	



	 
	 
}
