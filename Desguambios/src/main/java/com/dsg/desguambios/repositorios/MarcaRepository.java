package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Marca;
import com.dsg.desguambios.entidades.Producto;


public interface MarcaRepository extends JpaRepository<Marca, Long>{
	
	
	List<Producto> findAllByLit_Marca(String lit_marca);

}
