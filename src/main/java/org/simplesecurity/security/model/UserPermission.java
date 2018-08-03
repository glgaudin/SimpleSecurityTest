package org.simplesecurity.security.model;

import org.simplesecurity.security.SecuredUserPermission;

public class UserPermission implements SecuredUserPermission {

	private String permission;
	
	@Override
	public void setPermission(String permission) {
		this.permission = permission;

	}

	@Override
	public String getPermission() {
		return permission;
	}

}
