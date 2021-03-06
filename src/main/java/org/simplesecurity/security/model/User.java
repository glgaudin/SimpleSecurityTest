package org.simplesecurity.security.model;

import java.util.HashSet;
import java.util.Set;

import org.simplesecurity.security.SecuredUser;
import org.simplesecurity.security.SecuredUserPermission;

public class User implements SecuredUser {

	private Integer id;
	
	private String firstName;

	private String lastName;

	private String email;

	private String username;

	private String password;
	
	private Set<SecuredUserPermission> userAuthorities = new HashSet<>();
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
	}

	@Override
	public Set<SecuredUserPermission> getUserPermissions() {
		return userAuthorities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setUserPermissions(Set<? extends SecuredUserPermission> userPermissions) {
		this.userAuthorities = (Set<SecuredUserPermission>)userPermissions;
	}
}
