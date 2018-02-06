package com.dsg.desguambios;


public class Usuario {

	private String usuario;
	private String email;
	private String direccion;
	private String password;

	public Usuario() {

	}

	public Usuario(String usuario, String email, String direccion,String password) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.direccion = direccion;
		this.password = password;
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

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", direccion=" + direccion + "]";
	}
}
