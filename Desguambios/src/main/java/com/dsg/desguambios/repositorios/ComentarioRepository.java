package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	Comentario findByIdComentario(long idComentario);
	List<Comentario> findByContenido(String contenido);
	
	
	
	
}

