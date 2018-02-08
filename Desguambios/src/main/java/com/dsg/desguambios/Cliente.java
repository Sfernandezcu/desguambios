package com.dsg.desguambios;

public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String usuario;
	
	
	
	
	private String email;
	private String direccion;
	private String password;
	
	protected Cliente () {}
	
	public Cliente (String email, String direccion, String password) {
		this.email = email;
		this.direccion = direccion;
		this.password = password;
	}
	
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	
	public String getDireccion () {
		return direccion;	
	}
	
	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	

}
