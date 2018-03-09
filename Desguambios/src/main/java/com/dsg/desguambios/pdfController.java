package com.dsg.desguambios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.dsg.desguambios.entidades.Producto;
import com.dsg.desguambios.entidades.Usuario;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class pdfController {
	
	@Autowired 
	Usuario usuario;
	
	@GetMapping("/pdfFavoritos")
	public void pdfFavorito(HttpServletResponse response) throws IOException {
		RestTemplate rest =new RestTemplate();
		
		Map<String,List<Long>> json = new HashMap<>();
		List<Long> piezasId = new ArrayList<>();
		for (Producto producto : usuario.sacarLaLista()) {
			piezasId.add(producto.getIdProducto());
		}
		json.put("piezaIds", piezasId);
		
		 ObjectNode data = rest.postForObject("http://localhost:8080/pdfCreator",json, ObjectNode.class);

         byte[] bytes = data.get("pdf").binaryValue();
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         bos.write(bytes);
         bos.writeTo(response.getOutputStream());
         response.flushBuffer();
	}
	

}
