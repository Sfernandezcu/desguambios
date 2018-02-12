

package com.dsg.desguambios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dsg.desguambios.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}