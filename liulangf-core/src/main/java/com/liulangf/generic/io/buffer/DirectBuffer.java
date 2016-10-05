package com.liulangf.io.buffer;

import java.nio.ByteBuffer;

/**
 * The most significant way in which byte buffers are distinguished from other buffer types is 
 * that they can be the sources and/or targets of I/O performed by Channels.
 * Channels accept only ByteBuffers as arguments.
 * 
 * Direct buffers are intended for interaction with channels and native I/O routines. 
 * They make a best effort to store the byte elements in a memory area that a channel can use for direct, 
 * or raw, access by using native code to tell the operating system to drain or fill the memory area directly.
 * 
 * @author liulangf
 *
 */
public class DirectBuffer {
	
	public ByteBuffer direct() {
		return ByteBuffer.allocateDirect(10);
	}

}
