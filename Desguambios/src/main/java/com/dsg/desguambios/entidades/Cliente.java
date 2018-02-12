package com.dsg.desguambios.entidades;


//@Entity
public class Cliente {

	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String usuario;
	
	
	
	private String desguace;
	private String email;
	private String direccion;
	private String password;
	
	protected Cliente () {}
	
	public Cliente (String desguace,String email, String direccion, String password) {
		this.desguace = desguace;
		this.email = email;
		this.direccion = direccion;
		this.password = password;
	}
	
	public String getDesguace() {
		return this.desguace;
	}
	
	
	public void setDesguace(String desguace) {
		this.desguace = desguace;		
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

	@Override
	public String toString() {
		return "Cliente [usuario=" + usuario + ", email=" + email + ", direccion=" + direccion + ", password="
				+ password + "]";
	}
	

}
