package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dsg.desguambios.entidades.Desguace;


@CacheConfig(cacheNames="productos")
public interface DesguaceRepository extends JpaRepository<Desguace, String> {
	
	@CacheEvict(allEntries=true)//Vacia la caché entera, cuando un usuario hace login
	Desguace findByUsuario(String usuario);
	
	Desguace findByDireccion(String direccion);
	Desguace findByEmail(String email);
	Desguace findByPassword(String password);
	Desguace findByValPassword(String valPassword);
	
	
	
}