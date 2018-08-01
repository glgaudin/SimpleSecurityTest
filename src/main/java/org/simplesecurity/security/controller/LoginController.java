package org.simplesecurity.security.controller;

import javax.servlet.http.HttpServletResponse;

import org.simplesecurity.security.reponse.TokenValidationResponse;
import org.simplesecurity.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 

@RequestMapping("/")
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SecurityService securityService;

	/**
	 * log a user in and return a token
	 * 
	 * @param httpResponse
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="login", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> adminLogin(HttpServletResponse httpResponse, 
			@RequestParam(value="username") String username, @RequestParam(value="password") String password) {

		TokenValidationResponse response = securityService.login(username, password);
		addTokenToResponseHeader(httpResponse, response.getToken());

		return new ResponseEntity(HttpStatus.OK);
	}
	
}
