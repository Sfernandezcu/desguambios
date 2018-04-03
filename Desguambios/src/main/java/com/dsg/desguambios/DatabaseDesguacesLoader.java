package com.dsg.desguambios;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsg.desguambios.entidades.Comentario;
import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.repositorios.ComentarioRepository;
import com.dsg.desguambios.repositorios.DesguaceRepository;
import com.dsg.desguambios.repositorios.ProductoRepository;

@Component
public class DatabaseDesguacesLoader {
		@Autowired 
	    private DesguaceRepository desguaceRepository;
		
		@Autowired
		private ComentarioRepository comentarioRepository;
		
		@Autowired
	    private ProductoRepository productoRepository;

	    @PostConstruct
	    private void initDatabase() {
	    	
	    	Comentario comentario = new Comentario();
	    	comentario.setContenido("hola que tal");
	    	
	    	Comentario comentario1 = new Comentario();
	    	comentario1.setContenido("buen estado");
	    	
	    	Comentario comentario2 = new Comentario();
	    	comentario2.setContenido("como nuevo");
	    
	    	
	    	Comentario comentario4 = new Comentario();
	    	comentario4.setContenido("sin color");
	    	
	    	
	    
	    	
	    	desguaceRepository.save(	new Desguace("Pepe","pepe@gmail.com","Calle epep 123","pepe","pepe","ROLE_USER"));
			desguaceRepository.save(    new Desguace("Luis","pepe@gmail.com","Calle siul 123","luis","luis", "ROLE_USER"));
			
			
			
			Producto producto_A= new Producto("Retrovisor","Calle epep 123","Pepe","Bmw",comentario);
			Producto Producto_B= new Producto("Luna","Calle epep 123","Pepe","Mercedes",comentario1);
			Producto Producto_C= new Producto("Puerta","Calle epep 123","Pepe","Renault",comentario2);
			Producto Producto_E= new Producto("Luna","Calle siul 123","Luis","Audi",comentario4);
			
			
			
			
			
			productoRepository.save(producto_A);
			productoRepository.save(Producto_B);
			productoRepository.save(Producto_C);
			productoRepository.save(Producto_E);
	    }

}
