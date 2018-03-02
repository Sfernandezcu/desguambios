package com.dsg.desguambios;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.repositorios.DesguaceRepository;
import com.dsg.desguambios.repositorios.ProductoRepository;

@Component
public class DatabaseDesguacesLoader {
		@Autowired
	    private DesguaceRepository desguaceRepository;
		
		@Autowired
	    private ProductoRepository productoRepository;

	    @PostConstruct
	    private void initDatabase() {
	    	
	    	desguaceRepository.save(	new Desguace("Pepe","pepe@gmail.com","Calle epep 123","pepe","pepe","ROLE_USER"));
			desguaceRepository.save(new Desguace("Luis","pepe@gmail.com","Calle siul 123","luis","luis", "ROLE_USER"));
			
			Producto Producto_A= new Producto("Retrovisor","Calle epep 123","Pepe","Bmw");
			Producto Producto_B= new Producto("Luna","Calle epep 123","Pepe","Mercedes");
			Producto Producto_C= new Producto("Puerta","Calle epep 123","Pepe","Renault");
			Producto Producto_D= new Producto("Retrovisor","Calle siul 123","Luis","Citroen");
			Producto Producto_E= new Producto("Luna","Calle siul 123","Luis","Audi");
			Producto Producto_F= new Producto("Puerta","Calle siul 123","Luis","Opel");
			
			productoRepository.save(Producto_A);
			productoRepository.save(Producto_B);
			productoRepository.save(Producto_C);
			
			productoRepository.save(Producto_D);
			productoRepository.save(Producto_E);
			productoRepository.save(Producto_F);
	    }

}
