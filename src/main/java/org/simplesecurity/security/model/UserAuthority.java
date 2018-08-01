package org.simplesecurity.security.model;

import org.simplesecurity.security.SecuredUserAuthority;

public class UserAuthority implements SecuredUserAuthority {

	private String authority;
	
	@Override
	public void setAuthority(String authority) {
		this.authority = authority;

	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
