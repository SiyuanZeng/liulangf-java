package com.liulangf.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author liulangf
 *
 */
public class InputOuputStream {
	
	/**
	 * http://c2.com/cgi/wiki?ExecuteAroundMethod
	 * or
	 * JDK 7 try with resources
	 */
	public void executeArroundMethod(StreamClient client) {
		InputStream input = open();
		try {
			client.consume(input);
		} catch (IOException e) {
			client.onError(e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					client.onError(e);
				}
			}
		}
		
	}
	
	interface StreamClient {
		public void consume(InputStream input) throws IOException;
		public void onError(IOException e);
	}
	
	private InputStream open() {
		return null;
	}
	
	
	public void markSupported(InputStream input) {
		BufferedInputStream buffered = new BufferedInputStream(input);
		if (buffered.markSupported()) {
			buffered.mark(Integer.MAX_VALUE);
		}
	}

}
