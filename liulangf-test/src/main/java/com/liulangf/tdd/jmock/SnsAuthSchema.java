package com.liulangf.tdd.jmock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuYuQing
 */
public class SnsAuthSchema {
	private final static String PARA_NAME_API_KEY = "api_key";
	private Map<String, String> params = new HashMap<String, String>();

	/**
	 * just a test
	 * @return
	 */
    public String getApiKey() {
        return params.get(PARA_NAME_API_KEY);
    }
    
    public void put(String key, String value) {
    	params.put(key, value);
    }
}
