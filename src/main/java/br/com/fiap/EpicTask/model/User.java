package br.com.fiap.EpicTask.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity (name = "users" )
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "{user.name.empty}")
	private String name;
	
	@NotBlank (message = "o e-mail é obrigatório")
	@Email (message = "deve ser um e-mail válido")
	private String email;
	
	@Size(min = 8, message = "a senha deve ter pelo menos 8 caracteres")
	private String pass;
	
	@NotBlank (message = "{user.github.blank}")
	private String gitHubUser;
	
	public String getAvatar() {
		return "https://avatars.githubusercontent.com/" + gitHubUser;
	}
	
	public String getGitHubUser() {
		return gitHubUser;
	}

	public void setGitHubUser(String gitHubUser) {
		this.gitHubUser = gitHubUser;
	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.pass;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
