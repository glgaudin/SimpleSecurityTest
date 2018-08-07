package org.simplesecurity.security.service;

import java.util.HashMap;
import java.util.Map;

import org.simplesecurity.security.BasicPermissions;
import org.simplesecurity.security.SecuredUser;
import org.simplesecurity.security.model.User;
import org.simplesecurity.security.model.UserPermission;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl extends AbstractSimpleSecurityService {
	
	private static Map<Integer, User> users = new HashMap<>();

	static {
		createUser(1, "Bob", "Smith", "bsmith", BasicPermissions.READ.name());
		createUser(2, "Mary", "Admin", "admin", BasicPermissions.WRITE.name());
	}
	
	@Override
	public SecuredUser getUser(String id) {
		return users.get(Integer.parseInt(id));
	}

	@Override
	public SecuredUser getUser(String userName, String encryptedPassword) {
		for (Integer i: users.keySet()) {
			if (users.get(i).getUsername().equals(userName) && 
					users.get(i).getPassword().equals(encryptedPassword)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	private static void createUser(Integer id, String firstName, String lastName, String username, String permission) {
		
		User user = new User();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword("c55288f8b93bb8a7673226d2f95c2828a1377de7a96ff71f3cdda7b930b141ecfde1b61d27257fb3d62b6a8f9b78a0d4377e4d04f779a64b8284a0a29c3c9d4e");
		user.setId(id);

		if (permission != null) {
			UserPermission auth = new UserPermission();
			auth.setPermission(permission);
			
			user.getUserPermissions().add(auth);
		}		
		users.put(id, user);
	}

}
