package com.liulangf.io.reactor.doug.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author YuQing Liu
 *
 */
public class SimpleServer implements Runnable {
	private static final int PORT = 9000; 
	
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
			while (!Thread.interrupted()) {
				//one thread per connection
				new Thread(new Handler(ss.accept())).start();
			}
			
		} catch (IOException ex) {
		}
	}
	
	static class Handler implements Runnable {
		final Socket socket;
		Handler(Socket s) {
			socket = s;
		}
		
		public void run() {
			try {
				byte[] input = new byte[1024];
				socket.getInputStream().read(input);
				byte[] output = process(input);
				socket.getOutputStream().write(output);
			} catch (IOException ex) {
			}
		}
		
		private byte[] process(byte[] input) {
			return null;
		}
	}

}
