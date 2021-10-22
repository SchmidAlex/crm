package ch.zli.m223.crm.model;

import java.util.List;

public interface AppUser {
	
	public Long getId();
	public String getEmail();
	public List<String> getRoles();
}
