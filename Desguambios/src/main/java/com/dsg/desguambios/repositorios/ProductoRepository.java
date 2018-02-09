package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Producto;



//añadir consultas personalizadas
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	
	Producto findByIdProducto(int idProducto);
	
	
	List<Producto> findAllByLitProducto(String lit_producto);
	List<Producto> findAllByDirEmpresa(String dir_empresa);
	List<Producto> findAllByUsuario(String usuario);
	List<Producto> findAllByIdMarca(Integer id_marca);
	

	
}

