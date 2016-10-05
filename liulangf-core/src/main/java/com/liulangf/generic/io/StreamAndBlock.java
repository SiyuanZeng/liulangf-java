package com.liulangf.io;

/**
 * Java IO is stream-oriented.
 * Java NIO is block-oriented.
 * 
 * @author liulangf
 *
 */
public class StreamAndBlock {

	
	/**
	 * In Java, I/O has until recently been carried out using a stream metaphor.
	 * All I/O is viewed as the movement of single bytes, one at a time, through an object
	 * called a Stream. Stream I/O is used for contacting the outside world.
	 */
	public void streamOriented() {
	}

	/**
	 * NIO uses a different metaphor--block I/O. Block I/O can be a lot more efficient
	 * than stream I/O.
	 */
	public void blockOriented() {
	}
	
	
	/**
	 * Reading: Simply create a buffer and then ask a channel to read data into it.
	 * Writing: Simple create a buffer, fill it with data, and then ask a channel to write from it.
	 * 
	 */
	public void readWriteWithNIO() {
		
	}
	
}


























