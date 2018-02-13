

package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dsg.desguambios.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Producto findByIdProducto (Long idProducto);
	//Producto findByLitProducto (String litProducto);
	List<Producto> findByLitProductoIgnoreCase(String litProducto);
	//Producto findByDir_empresa (String dir_empresa);
	List<Producto> findByUsuario (String usuario);
	//Producto findById_marca (String id_marca);
	List<Producto> findByLitProductoContainingIgnoreCaseAndIdMarcaContainingIgnoreCase(String litProducto, String idMarca);
	List<Producto> findByIdMarcaIgnoreCase(String idMarca);
	
	
}