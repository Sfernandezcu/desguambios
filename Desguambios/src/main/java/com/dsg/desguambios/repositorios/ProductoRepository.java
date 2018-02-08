package com.dsg.desguambios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Producto;

//añadir consultas personalizadas
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
