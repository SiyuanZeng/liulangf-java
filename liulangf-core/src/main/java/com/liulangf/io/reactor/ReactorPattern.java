package com.liulangf.io.reactor;

/**
 * http://www.cs.wustl.edu/~schmidt/patterns-ace.html
 * 
 * An Object Behavioral Pattern for Demultiplexing and Dispatching Handles for Synchronous Events.
 * 
 * reactor(反应堆)模式提供了一种很好的事件处理机制，以分离事件处理对象与事件之间的耦合。
 * 
 * Thread-on-event vs. thread-on-connection.
 * 
 * Known frameworks:
 * <ul>
 *   <li>Apache MINA</li>
 *   <li>Apache cocoon(for xml processing)</li>
 *   <li>JBoss Netty</li>
 *   <li>Grizzly</li>
 * </ul>
 * 
 * Asynchronous IO: IO becomes event based.
 * 
 * <ul>
 *   <li>Acceptor</li>
 *   <li>Dispatcher</li>
 *   <li>EventHandler</li>
 * </ul>
 * 
 * 
 * @author YuQing Liu
 *
 */
public class ReactorPattern {
	
	/**
	 * Reactor responds to IO events by dispatching the appropriate handler.
	 *   -- Similar to AWT(GUI) thread
	 */
	void reactor() {}
	
	/**
	 * Handlers perform non-blocking actions
	 *   -- Similar to AWT(GUI) ActionListener
	 */
	void handler() {}

	/**
	 * Manage by binding handlers to events
	 *   -- Similar to AWT(GUI) addActionListener
	 */
	void binding() {}
	
	interface JavaNIOSupported {
		
		/**
		 * Channels: Connections to files, sockets etc that support non-blocking reads.
		 */
		void channel();
		
		/**
		 * Buffers: Array-like objects that can be directly read or written by channels.
		 */
		void buffer();
		
		/**
		 * Selectors: Tell which of a set of Channels have IO event.
		 */
		void selector();
		
		/**
		 * SelectionKeys: Maintain IO event status and bindings.
		 */
		void selectionKey();
		
	}
}
