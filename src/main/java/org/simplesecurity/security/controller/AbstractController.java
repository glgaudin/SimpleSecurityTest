package org.simplesecurity.security.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class AbstractController implements Serializable {
	static final String HEADER_SECURITY_TOKEN = "X-Token";
	
	/**
	 * Add the token to the response header
	 * 
	 * @param httpResponse
	 * @param token
	 */
	void addTokenToResponseHeader(HttpServletResponse httpResponse, String token) {
		httpResponse.addHeader(HEADER_SECURITY_TOKEN, token);
	}
}
