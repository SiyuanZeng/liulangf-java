package com.liulangf.io.channel;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * New I/O metaphor: Conduit to an I/O service("nexus").
 * 
 * Channels do bulk data transfers to and from buffers.
 * Scatter/gather, channel-to-channel transfers.
 * 
 * Channels are analogous to streams in the original I/O package. All data that goes 
 * anywhere(or come from anywhere) must pass through a Channel object. 
 * A Buffer is essentially a container object. All data that is sent to a channel must
 * first be placed in a buffer; likewise, any data that is read from a channel is read into a buffer.
 * 
 * 
 * @author liulangf
 *
 */
public class WhatIsChannel {

	/**
	 * <ul>
	 *  <li>FileChannel: File locks, memory mapping, cross-connect transfers</li>
	 *  <li>Sockets    : Non-blocking, selectable, async connections, peers</li>
	 *  <li>Pipe       : loopback channel pair, selectable, generic channels </li>
	 * </ul>
	 */
	public void threePrimaryChannel() {
		//Factory methods in Channels.
		java.nio.channels.Channels.newChannel(System.out);
	}

	/**
	 * The content of buffer is the content of fileName 
	 * Any change to one affects the other
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void memoryMappedBuffer(String fileName) throws IOException {
		RandomAccessFile raf = new RandomAccessFile (fileName, "rw");
		FileChannel fc = raf.getChannel();
		MappedByteBuffer buffer = fc.map (FileChannel.MapMode.READ_WRITE, 0, fc.size());

		byte b = buffer.get();		// reads from file
		//...
		buffer.put (new byte[]{});	// writes to file
	}
	
	interface Channel extends Closeable {
		public boolean isOpen();
		public void close() throws IOException;
		
		//Reads a sequence of bytes from this channel into the given buffer.
		public int read(ByteBuffer dst) throws IOException;
		//Writes a sequence of bytes to this channel from the given buffer.
		public int write(ByteBuffer src) throws IOException;
	}

}
