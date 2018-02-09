package com.dsg.desguambios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Cliente findByUsuario(String usuario);
	

}
