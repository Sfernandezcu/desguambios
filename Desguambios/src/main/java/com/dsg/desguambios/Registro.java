package com.dsg.desguambios;

public class Registro {
	
	private String usuario;
	private String email;
	private String direccion;
	private String password;
	private String valPassword;
	
	public Registro() {
		
	}
	
	public Registro(String usuario, String email, String direccion, String password
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
	


}
