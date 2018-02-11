package com.dsg.desguambios.repositorios;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dsg.desguambios.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Cliente findByUsuario(String usuario);
	

}
