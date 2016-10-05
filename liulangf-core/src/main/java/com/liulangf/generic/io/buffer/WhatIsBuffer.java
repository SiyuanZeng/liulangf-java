package com.liulangf.io.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Buffers work hand in glove with channels. 
 * Channels are portals through which I/O transfers take place, 
 * and buffers are the sources or targets of those data transfers.
 * 
 * @author liulangf
 *
 */
public class WhatIsBuffer {

	/**
	 * Invariants: 0 <= mark <= position <= limit <= capacity
	 * <ul>
	 *  <li>capacity</li>
	 *  <li>limit</li>
	 *  <li>position</li>
	 *  <li>mark</li>
	 * </ul>
	 */
	public void propertyOfBuffer() {
	}
	
	/**
	 * Clearing, flipping, and rewinding:
	 * <ul>
	 *  <li>clear() makes a buffer ready for a new sequence of channel-read or relative put operations: 
	 *    It sets the limit to the capacity and the position to zero.</li>
	 *  <li>flip() makes a buffer ready for a new sequence of channel-write or relative get operations: 
	 *    It sets the limit to the current position and then sets the position to zero. </li>
	 *  <li>rewind() makes a buffer ready for re-reading the data that it already contains: 
	 *    It leaves the limit unchanged and sets the position to zero.</li>
	 * </ul>
	 */
	public void operationOfBuffer() {
		ByteBuffer bb = ByteBuffer.allocate(10);
		bb.clear(); //for channel-reading in.read(bb);
		bb.flip();  //for channel-writing out.write(bb);
		bb.rewind();
		bb.isDirect();
		bb.mark();
		bb.reset();
	}
	
	public void invocationChaining(Buffer buffer) {
		buffer.flip();
		buffer.position(23);
		buffer.limit(40);
		//===>
		buffer.flip().position(23).limit(40);
	}

	/**
	 * We've filled the buffer, now we must prepare it for draining. 
	 * We want to pass this buffer to a channel so the content can be written out. 
	 * But if the channel performs a get( ) on the buffer now, it will fetch undefined data 
	 * from beyond the good data we just inserted. If we set the position back to 0, the channel 
	 * will start fetching at the right place, but how will it know when it has reached the end of the 
	 * data we inserted? This is where the limit attribute comes in. 
	 * 
	 * The limit indicates the end of the active buffer content. 
	 * We need to set the limit to the current position, then reset the position to 0.
	 * We can do so manually with code like this:
	 *   buffer.limit(buffer.position( )).position(0);
	 * But this flipping of buffers from fill to drain state was anticipated by the designers of the API;
	 *  buffer.flip();
	 *  
	 * The flip( ) method flips a buffer from a fill state, where data elements can be appended, 
	 * to a drain state ready for elements to be read out.
	 */
	public void flip() {
	}
	
	/**
	 * The rewind( ) method is similar to flip( ) but does not affect the limit. 
	 * It only sets the position back to 0. You can use rewind( ) to go back and 
	 * reread the data in a buffer that has already been flipped.
	 */
	public void rewind() {
		
	}

}
