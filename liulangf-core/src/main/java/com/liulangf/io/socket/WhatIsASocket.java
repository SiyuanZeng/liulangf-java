package com.liulangf.io.socket;

/**
 * @author YuQing Liu
 *
 */
public interface WhatIsASocket {
	
	/**
	 * The main types of sockets in TCP/IP today are stream sockets and datagram sockets. 
	 * Stream sockets use TCP as the end-to-end protocol (with IP underneath) and thus provide a 
	 * reliable byte-stream service. A TCP/IP stream socket represents one end of a TCP connection.
	 * 
	 * A TCP/IP socket is uniquely identified by an Internet address, an end-to-end protocol (TCP or UDP), 
	 * and a port number. There are several ways for a socket to become bound to an address.
	 */
	void stream_socket();
	
	/**
	 * java.net.InetAddress
	 * java.net.SocketAddress
	 * java.net.NetworkInterface
	 */
	void address();
	
}
