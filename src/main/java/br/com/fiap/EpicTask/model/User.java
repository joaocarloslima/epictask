package br.com.fiap.EpicTask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity (name = "users" )
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{user.name.empty}")
	private String name;

	@NotBlank (message = "o e-mail é obrigatório")
	@Email(message = "deve ser um e-mail válido")
	private String email;
	
	@NotBlank
	@Size(min = 8, message = "a senha deve ter pelo menos 8 chars")
	private String pass;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Nome = " + this.name +
				" (" + this.email + ")";
	}
	
	
	
	
}
