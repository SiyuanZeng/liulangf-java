package com.liulangf.io.reactor;

/**
 * <ul>
 *   <li>Handle: A reference to an event source, such as a socket</li>
 *   <li>Event: A state change that can occur on a Handle</li>
 *   <li>Demultiplexer: Reacts to and interprets Events on Handles.</li>
 *   <li>Dispatcher: Invokes Handlers for Events on Handles</li>
 *   <li>Handler:</li>
 * </ul>
 * 
 * 
 * @author YuQing Liu
 *
 */
public interface ReactorPatternParticipant {
	

	/**
	 * 1. A server processes requests:
	 *   a. Receive a client request. [Dispatcher]
	 *   b. Perform some request-specific task. [Handler]
	 *   c. Return a response. [Dispatcher]
	 *  
	 * 2. Multiple requests run concurrently. [Demultiplexer]
	 * 3. Client requests correspond to connections [Handle]
	 * 4. Multi
	 * 
	 */
	void what_does_a_server_do();
	
}
