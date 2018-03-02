package com.dsg.desguambios;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsg.desguambios.entidades.Desguace;
import com.dsg.desguambios.repositorios.DesguaceRepository;

@Component
public class DatabaseDesguacesLoader {
	  @Autowired
	    private DesguaceRepository desguaceRepository;

	    @PostConstruct
	    private void initDatabase() {
	    	
	    	desguaceRepository.save(	new Desguace("Pepe","pepe@gmail.com","Calle epep 123","pepe","pepe","ROLE_USER"));
			desguaceRepository.save(new Desguace("Luis","pepe@gmail.com","Calle siul 123","luis","luis", "ROLE_USER"));
	    }

}
