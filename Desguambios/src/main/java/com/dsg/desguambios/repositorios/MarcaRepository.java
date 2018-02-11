package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsg.desguambios.entidades.Marca;


@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	
	
	Marca findByIdMarca(int idMarca);
	
	
	List<Marca> findAllByLit_Marca(String lit_marca);

}
