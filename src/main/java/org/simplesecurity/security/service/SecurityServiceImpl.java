package org.simplesecurity.security.service;

import java.util.HashMap;
import java.util.Map;

import org.simplesecurity.security.BasicAuthority;
import org.simplesecurity.security.SecuredUser;
import org.simplesecurity.security.model.User;
import org.simplesecurity.security.model.UserAuthority;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:simplesecurity.properties")
@Service
public class SecurityServiceImpl extends AbstractSecurityService {
	
	private static Map<Integer, User> users = new HashMap<>();

	static {
		createUser(1, "Bob", "Smith", BasicAuthority.READ.name());
		createUser(2, "Mary", "Null", BasicAuthority.READ.name());
	}
	
	@Override
	SecuredUser getUser(String id) {
		return users.get(Integer.parseInt(id));
	}

	@Override
	SecuredUser getUser(String userName, String encryptedPassword) {
		return users.get(1);
	}
	
	private static void createUser(Integer id, String firstName, String lastName, String permission) {
		
		User user = new User();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword("c55288f8b93bb8a7673226d2f95c2828a1377de7a96ff71f3cdda7b930b141ecfde1b61d27257fb3d62b6a8f9b78a0d4377e4d04f779a64b8284a0a29c3c9d4e");
		user.setId(id);
		
		UserAuthority auth = new UserAuthority();
		auth.setAuthority(permission);
		
		user.getUserAuthorities().add(auth);
		
		users.put(id, user);
	}

}
