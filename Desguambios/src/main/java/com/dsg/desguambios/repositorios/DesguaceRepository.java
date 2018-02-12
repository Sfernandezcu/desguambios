package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Desguace;



public interface DesguaceRepository extends JpaRepository<Desguace, String> {
	
	List<Desguace> findByUsuario(String usuario);
	List<Desguace> findByDireccion(String direccion);
	List<Desguace> findByEmail(String email);
	List<Desguace> findByPassword(String password);
	List<Desguace> findByValPassword(String valPassword);
	
}