package com.liulangf.io.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * java.net.Socket
 * java.net.ServerSocket
 * 
 * By default, Socket is implemented on top of a TCP connection; however, in Java, 
 * you can actually change the underlying implementation of Socket.
 * 
 * @author YuQing Liu
 *
 */
public class TCPSocket {
	
	/**
	 * TCP/IP is connection based protocol.
	 * 
	 * A TCP connection is an abstract two-way channel whose ends are each identified by an IP address and port number. 
	 * Before being used for communication, a TCP connection must go through a setup phase, which starts with the client’s 
	 * TCP sending a connection request to the server’s TCP. An instance of ServerSocket listens for TCP connection requests 
	 * and creates a new Socket instance to handle each incoming connection. Thus, servers handle both ServerSocket and Socket 
	 * instances, while clients use only Socket.
	 */
	void client_server_mode() {}
	
	/**
	 * {@link java.net.Socket#connect(java.net.SocketAddress)}
	 * 
	 * The connect() methods cause a TCP connection to the specified endpoints to be opened.
	 * 
	 * Communication with the remote system takes place via the associated I/O streams, 
	 * which are obtained through the get . . . Stream() methods.
	 * 
	 */
	void connection() throws Exception {
		//connect when init
		Socket socket = new Socket("www.google.com", 8080);
		
		//explicitly connect
		socket = new Socket();
		socket.connect(new InetSocketAddress("www.google.com", 8080));
		
		//Sending request
		OutputStream command = socket.getOutputStream();
		//Fetching response
		InputStream input = socket.getInputStream();
	}
	
	/**
	 * The server’s job is to set up a communication endpoint and passively wait for connections from clients.
	 */
	void tcp_server() throws Exception {
		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(9090);
	    int recvMsgSize;   // Size of received message
	    byte[] receiveBuf = new byte[1024];  // Receive buffer
	    while (true) { // Run forever, accepting and servicing connections
	        Socket clntSock = servSock.accept();     // Get client connection

	        SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
	        System.out.println("Handling client at " + clientAddress);
	        
	        InputStream in = clntSock.getInputStream();
	        OutputStream out = clntSock.getOutputStream();

	        // Receive until client closes connection, indicated by -1 return
	        while ((recvMsgSize = in.read(receiveBuf)) != -1) {
	          out.write(receiveBuf, 0, recvMsgSize);
	        }

	        clntSock.close();  // Close the socket.  We are done with this client!
	      }
	}
	
	/**
	 * Call the accept() method of ServerSocket to get the next incoming client connection. 
	 * Upon establishment of a new client connection, an instance of Socket for the new connection 
	 * is created and returned by accept().
	 * 
	 * The sole purpose of a ServerSocket instance is to supply a new, connected Socket instance for 
	 * each new incoming TCP connection. When the server is ready to handle a client, it calls accept(), 
	 * which blocks until an incoming connection is made to the ServerSocket’s port.
	 */
	void accept() {}

}
