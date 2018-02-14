package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Imagen;



public interface ImagenRepository extends JpaRepository<Imagen, Long> {
	Imagen findByIdImagen(long idImagen);
	List<Imagen> findByIdProducto(long idProducto);
	List<Imagen> findByUrl (String url);

	
}