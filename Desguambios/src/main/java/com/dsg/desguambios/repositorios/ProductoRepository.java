package com.dsg.desguambios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Producto;



//añadir consultas personalizadas
public interface ProductoRepository extends JpaRepository<Producto, Long>{

	
	Producto findById_producto(long id_producto);
	
	
	List<Producto> findAllByLitProducto(String lit_producto);
	List<Producto> findAllByDirEmpresa(String dir_empresa);
	List<Producto> findAllByUsuario(String usuario);
	List<Producto> findAllByIdMarca(Integer id_marca);
	

	
}

