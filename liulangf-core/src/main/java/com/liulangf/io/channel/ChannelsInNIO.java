package com.liulangf.io.channel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * There are two types of channels: file and socket.
 * There is one FileChannel class and three socket channel classes: 
 * SocketChannel, ServerSocketChannel, and DatagramChannel.
 * 
 * @author liulangf
 *
 */
public class ChannelsInNIO {
	

	/**
	 * <ul>
	 *   <li>java.nio.Channel</li>
	 *   <li>java.nio.ReadableByteChannel</li>
	 *   <li>java.nio.WritableByteChannel</li>
	 *   <li>java.nio.ByteChannel</li>
	 *   <li>java.nio.GathringByteChannel</li>
	 *   <li>java.nio.ScatteringByteChannel</li>
	 * </ul>
	 */
	public void channelInterface() {
	}

	/**
	 * <ul>
	 *   <li>java.nio.FileChannel</li>
	 *   <li>java.nio.DatagramChannel</li>
	 *   <li>java.nio.Pipe.SinkChannel</li>
	 *   <li>java.nio.Pipe.SourceChannel</li>
	 *   <li>java.nio.SelectableChannel</li>
	 *   <li>java.nio.SocketChannel</li>
	 *   <li>java.nio.ServerSocketChannel</li>
	 * </ul>
	 */
	public void channelClass() {
	}

	/**
	 * Channels can be created in several ways. 
	 * The socket channels have factory methods to create new socket channels directly. 
	 * But a FileChannel object can be obtained only by calling the getChannel() method on 
	 * an open RandomAccessFile, FileInputStream, or FileOutputStream object. 
	 * You cannot create a FileChannel object directly.
	 * 
	 * @throws Exception
	 */
	public void channelFactory() throws Exception {
		ReadableByteChannel rbc = Channels.newChannel(new ByteArrayInputStream("String".getBytes()));
		WritableByteChannel wbc = Channels.newChannel(new ByteArrayOutputStream());
		
		FileChannel fc1 = new FileOutputStream("baidu.txt").getChannel();
		FileChannel fc2 = new FileInputStream("baidu.txt").getChannel();
		FileChannel fc3 = new RandomAccessFile("baidu.txt", "rw").getChannel();
		
		SocketChannel sc = SocketChannel.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		DatagramChannel dc = DatagramChannel.open();
	}
	
	/**
	 * Unlike buffers, channels cannot be reused. An open channel represents a specific connection 
	 * to a specific I/O service and encapsulates the state of that connection. 
	 * When a channel is closed, that connection is lost, and the channel is no longer connected to anything.
	 */
	public void closeChannel() {
		
	}
}
