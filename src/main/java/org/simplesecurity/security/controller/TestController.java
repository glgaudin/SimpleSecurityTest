package org.simplesecurity.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.simplesecurity.security.reponse.TokenValidationResponse;
import org.simplesecurity.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 

@PropertySource("classpath:simplesecurity.properties")
@RequestMapping("/")
public class TestController {

	private static final long serialVersionUID = 1L;
	static final String HEADER_SECURITY_TOKEN = "X-Token";

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
	
	/**
	 * basic test endpoint which returns a success
	 * 
	 * @param httpResponse
	 * @param token
	 * @return
	 */
	@RequestMapping(value="test", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getTestStuff(HttpServletResponse httpResponse, 
			@RequestHeader(value=HEADER_SECURITY_TOKEN) String token) {

		return new ResponseEntity<List<String>>(new ArrayList<>(),HttpStatus.OK);
	}
	
	void addTokenToResponseHeader(HttpServletResponse httpResponse, String token) {
		httpResponse.addHeader(HEADER_SECURITY_TOKEN, token);
	}
	
}
