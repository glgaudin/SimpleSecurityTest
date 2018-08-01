package org.simplesecurity.security.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/api/")
public class TestController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * basic test endpoint which returns a success
	 * 
	 * @param httpResponse
	 * @param token
	 * @return
	 */
	@RequestMapping(value="test", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getDormsForLoggedInUser(HttpServletResponse httpResponse, 
			@RequestHeader(value=HEADER_SECURITY_TOKEN) String token) {

		return new ResponseEntity<String>("IT WORKED",HttpStatus.OK);
	}
	
}
