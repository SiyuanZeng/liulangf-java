package com.liulangf.io.reactor.doug.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author YuQing Liu
 *
 */
public class Reactor implements Runnable {
	final Selector selector;
	final ServerSocketChannel serverSocket;
	
	Reactor(int port) throws IOException {
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		serverSocket.socket().bind(new InetSocketAddress(port));
		//set non-blocking mode
		serverSocket.configureBlocking(false);
		SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		sk.attach(new Acceptor());
	}
	
	public void run() {
		try {
			while (!Thread.interrupted()) {
				selector.select();
				Set<SelectionKey> selected = selector.selectedKeys();
				Iterator<SelectionKey> it = selected.iterator();
				while (it.hasNext()) {
					dispatch(it.next());
				}
				selected.clear();
			}
		} catch (IOException ex) {
		}
	}
	
	public void dispatch(SelectionKey sk) {
		Runnable r = (Runnable)sk.attachment();
		if (r != null) {
			r.run();
		}
	}
	
	class Acceptor implements Runnable {
		public void run() {
			try {
				SocketChannel c = serverSocket.accept();
				if (c != null) {
					new Handler(selector, c);
				}
			} catch (IOException e) {
			}
		}
	}
	
	final class Handler implements Runnable {
		final SocketChannel socket;
		final SelectionKey sk;
		
		Handler(Selector sel, SocketChannel c) throws ClosedChannelException {
			socket = c;
			sk = socket.register(sel, 0);
			sk.attach(this);
			sk.interestOps(SelectionKey.OP_READ);
			sel.wakeup();
		}
		
		public void run() {
			
		}
	}

}
