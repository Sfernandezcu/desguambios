package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class Inicio {
	@Autowired
	 private UserService usersService;
	
	 @RequestMapping("/index")
	 public String greeting(Model model) {
	 model.addAttribute("name",
	 usersService.getNumUsers()+" users");

	 return "index";
}
