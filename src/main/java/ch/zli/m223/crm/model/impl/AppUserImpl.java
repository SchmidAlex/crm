package ch.zli.m223.crm.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.zli.m223.crm.model.AppUser;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser{

	@Id //makes the id to the primary-key
	@GeneratedValue //makes an auto-increment on the id
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String email;

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleImpl> roles;
	
	public AppUserImpl(String email, String password) {
		this.email = email;
		roles = new ArrayList<>();
	}
	
	protected AppUserImpl() {
		
	}//For JPA only
	
	@Override
	public List<String> getRoles(){
		return roles.stream().map((RoleImpl role ) -> {
			return role.getRole();
		})
		.collect(Collectors.toList());
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void addRole(RoleImpl role) {
		roles.add(role);
	}

}
