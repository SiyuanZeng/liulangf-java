package com.liulangf.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public abstract class ConfigLoader {
	
	public abstract URL getUrl(String uri);
	
	public InputStream getInputStream(String uri) throws IOException {
		URLConnection con = getUrl(uri).openConnection();
		con.setUseCaches(false);
		try {
			return con.getInputStream();
		} catch (IOException ex) {
			if (con instanceof HttpURLConnection) {
				((HttpURLConnection) con).disconnect();
			}
			throw ex;
		}
	}
	
}
