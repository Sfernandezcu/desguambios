package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsg.desguambios.entidades.Imagen;


@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {

	Imagen findByIdImagen(int idImagen); 
	
	List<Imagen> findAllById_producto(int id_producto);
	
	
}
