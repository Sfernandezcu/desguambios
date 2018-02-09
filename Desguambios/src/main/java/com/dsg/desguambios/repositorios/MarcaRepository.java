package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Marca;



public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	
	
	Marca findByIdMarca(int idMarca);
	
	
	List<Marca> findAllByLit_Marca(String lit_marca);

}
