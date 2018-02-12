package com.dsg.desguambios.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
@Entity
public class Desguace {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String usuario;
	
	
	private String email;
	private String direccion;
	private String password;
	private String valPassword;
	
	
	public Desguace() {
		
	}
	
	public Desguace(String usuario, String email, String direccion, String password
			, String valPassword) {
		this.usuario = usuario;
		this.email = email;
		this.direccion = direccion;
		this.password = password;
		this.valPassword = valPassword;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValPassword() {
		return valPassword;
	}
	public void setValPassword(String valPassword) {
		this.valPassword = valPassword;
	}

	@Override
	public String toString() {
		return "Desguace [usuario=" + usuario + ", email=" + email + ", direccion=" + direccion + ", password="
				+ password + ", valPassword=" + valPassword + "]";
	}

	


}
