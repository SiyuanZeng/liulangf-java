package com.liulangf.io.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author YuQing Liu
 *
 */
public class NonBlockingServer {

	/**
	 * The server has only one thread, which deals with all clients - not sequentially, but all at once.
	 * Such a server must use nonblocking IO exclusively.
	 * 
	 * What we need is a way to poll a set of clients all at once, to find out which ones need service. 
	 * That is exactly the point of the Selector and Channel abstractions introduced in NIO.
	 * 
	 * A Channel instance represents a “pollable” I/O target such as a socket (or a file, or a device). 
	 * Channels can register an instance of class Selector. The select() method of Selector allows you to 
	 * ask “Among the set of channels, which ones are currently ready to be serviced (i.e., accepted, read, or written)?”
	 */
	void singleThreadServer() {
	}

	/**
	 * A Channel instance represents a connection to a device through which we can perform I/O.
	 * For TCP, use the ServerSocketChannel and SocketChannel. 
	 * 
	 * Channels do not use streams; instead, they send/receive data from/to buffers.
	 * Part of the power of NIO comes from the fact that channels can be made nonblocking.
	 */
	void channels_for_tcp() throws Exception {
		//One difference between channels and sockets is that typically one 
		//obtains a channel instance by calling a static factory method:
		SocketChannel clntChan = SocketChannel.open();
		ServerSocketChannel servChan = ServerSocketChannel.open();
		
		//An important feature of the NIO channel abstraction is that we c
		//an make a channel nonblocking by configuring its blocking behavior:
		clntChan.configureBlocking(false);
		
		//Calls to methods on a nonblocking channel always return immediately. The return 
		//value of such a call indicates the extent to which the requested operation was achieved.
	}

	/**
	 * The I/O operations that may block include connecting, reading, and writing. 
	 * With a nonblocking channel, these operations return immediately. 
	 * We must repeatedly call these operations until we have successfully completed all I/O.
	 */
	void nonblocking_client() throws Exception {
		// Create channel and set to nonblocking
		SocketChannel clntChan = SocketChannel.open();
		clntChan.configureBlocking(false);
		
		// Initiate connection to server and repeatedly poll until complete
		if (!clntChan.connect(new InetSocketAddress("www.google.com", 9090))) {
		    while (!clntChan.finishConnect()) {
		        System.out.print("."); // Do something else
		    }
		}
		
		//do business logic ...
		
		clntChan.close();
	}
	
	/**
	 * An instance of Selector can simultaneously check (and wait, if desired) for I/O opportunities on a set of channels. 
	 * In technical terms, a selector is a multiplexor because a single selector can manage I/O on multiple channels.
	 * 
	 */
	void selector() throws Exception {
		// Create a selector to multiplex listening sockets and connections
		Selector selector = Selector.open();
		
		ServerSocketChannel listnChannel = ServerSocketChannel.open();
		listnChannel.socket().bind(new InetSocketAddress(9090));
		listnChannel.configureBlocking(false); // must be nonblocking to register
		// Register selector with channel. The returned key is ignored
		listnChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		long TIMEOUT = 1000;
		
		while (true) { // Run forever, processing available I/O operations
			// Wait for some channel to be ready (or timeout)
			if (selector.select(TIMEOUT) == 0) { // returns # of ready chans
				System.out.print(".");
				continue;
			}

			// Get iterator on set of keys with I/O to process
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			while (keyIter.hasNext()) {
				SelectionKey key = keyIter.next(); // Key is bit mask
				// Server socket channel has pending connection requests?
				if (key.isAcceptable()) {
					// protocol.handleAccept(key);
				}
				// Client socket channel has pending data?
				if (key.isReadable()) {
					// protocol.handleRead(key);
				}
				// Client socket channel is available for writing and
				// key is valid (i.e., channel not closed)?
				if (key.isValid() && key.isWritable()) {
					// protocol.handleWrite(key);
				}
				keyIter.remove(); // remove from set of selected keys
			}
		}
	}
	
	public void handleAccept(SelectionKey key) throws IOException {
		SocketChannel clntChan = ((ServerSocketChannel) key.channel()).accept();
		clntChan.configureBlocking(false); // Must be nonblocking to register
		// Register the selector with new channel for read and attach bytebuffer
		clntChan.register(key.selector(), SelectionKey.OP_READ,	ByteBuffer.allocate(200));
	}
	
	/**
	 * When a channel is ready for I/O, we often need additional information to process the request.
	 * SelectionKeys make storing per-channel state easy with attachments.
	 * 
	 * Each key can have one attachment, which can be any object. An attachment can be associated 
	 * when the channel’s register() method is first called, or added directly to the key later, 
	 * with the attach() method. A key’s attachment can be accessed using the SelectionKey’s attachment() method.
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void handleRead(SelectionKey key) throws IOException {
		// Client socket channel has pending data
		SocketChannel clntChan = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = clntChan.read(buf);
		if (bytesRead == -1) { // Did the other end close?
			clntChan.close();
		} else if (bytesRead > 0) {
			// Indicate via key that reading/writing are both of interest now.
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}
	}
	
	/**
	 * Each selector has an associated set of channels which it monitors for specific I/O “operations of interest” 
	 * to that channel. The association between a Selector and a Channel is represented by an instance of SelectionKey. 
	 * (Note that a Channel instance can register more than one Selector instance, and so can have more than one 
	 * associated instance of SelectionKey.) 
	 * 
	 * The SelectionKey maintains information about the kinds of operations that are of interest for a channel in 
	 * a bitmap, which is just an int in which individual bits have assigned meanings.
	 */
	void selectionKey() {
		
	}

}
