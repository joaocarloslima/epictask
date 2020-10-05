package br.com.fiap.EpicTask.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity(name = "users")
@Data
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{user.name.blank}")
	private String name;
	
	@NotBlank (message = "{user.email.blank}")
	@Email(message = "{user.email.pattern}")
	private String email;
	
	@Size(min = 8, message = "{user.password.size}")
	private String pass;
	
	@NotBlank (message = "{user.github.blank}")
	private String gitHubUser;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<Role>();
	
	private int point;
	
	
	
	public String getAvatar() {
		return "https://avatars.githubusercontent.com/" + gitHubUser;
	}
	
	public String getFirstName() {
		String[] arrayName = this.name.split(" ");
		return arrayName[0];
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
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

	public void toScore(int point) {
		if (point > 0) {
			this.setPoint(this.point + point);		
		}
	}
	
}
