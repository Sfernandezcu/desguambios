

package com.dsg.desguambios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dsg.desguambios.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Producto findByIdProducto (String idProducto);
	//Producto findByLit_producto (String lit_producto);
	//Producto findByDir_empresa (String dir_empresa);
	Producto findByUsuario (String usuario);
	//Producto findById_marca (String id_marca);
	
}