package com.liulangf.tdd.jmock;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuYuQing
 */
public class SignatureHandler {
	
	public void authCheck(HttpServletRequest request) 
	    throws SignatureException {
		SnsAuthSchema schema = 
			(SnsAuthSchema) request.getAttribute("sns_auth_schema");
		String apiKey = schema.getApiKey();
		
		if (apiKey == null || apiKey.trim().length() == 0) {
			throw new SignatureException("Api key needed!");
		}
		
		if (!apiKey.equals("hello_tdd")) {
			throw new SignatureException("Api key error!");
		}
		
	}
}
