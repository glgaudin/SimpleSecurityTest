package org.simplesecurity.security.service;

import java.util.HashMap;
import java.util.Map;

import org.simplesecurity.security.BasicAuthority;
import org.simplesecurity.security.SecuredUser;
import org.simplesecurity.security.model.User;
import org.simplesecurity.security.model.UserAuthority;
import org.springframework.stereotype.Service;

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
		throw new UnsupportedOperationException();
	}
	
	private static void createUser(Integer id, String firstName, String lastName, String permission) {
		
		User user = new User();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setId(id);
		
		UserAuthority auth = new UserAuthority();
		auth.setAuthority(permission);
		
		user.getUserAuthorities().add(auth);
		
		users.put(id, user);
	}

}
