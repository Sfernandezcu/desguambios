package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Desguace;



public interface DesguaceRepository extends JpaRepository<Desguace, String> {
	
	Desguace findByUsuario(String usuario);
	Desguace findByDireccion(String direccion);
	Desguace findByEmail(String email);
	Desguace findByPassword(String password);
	Desguace findByValPassword(String valPassword);
	
}