package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controlador {

	@Autowired
	 private UserService usersService;
	
	 @RequestMapping("/nombre_url")
	 public String greeting(Model model) {
	 model.addAttribute("name",
	 usersService.getNumUsers()+" users");

	 return "prueba";
	 }

}
