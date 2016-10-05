package com.liulangf.io.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.ReadableByteChannel;

/**
 * FileChannel class can do normal read and write as well as scatter/gather. 
 * It also provides lots of new methods specific to files.
 * 
 * File channels are always blocking and cannot be placed into nonblocking mode.
 * 
 * Reading from a file involes three steps:
 * <ul>
 *  <li>Getting the Channel from FileInputStream</li>
 *  <li>Creating the Buffer</li>
 *  <li>Reading from the Channel into the Buffer</li>
 * </ul>
 * 
 * 
 * 
 * @author liulangf
 *
 */
public class FileChannelUsage {
	
	public void usage() throws IOException {
		FileOutputStream out = new FileOutputStream("baidu.txt");
		FileChannel channel = out.getChannel();
		URL url = new URL("http://www.baidu.com");
		InputStream input = url.openStream();
		ReadableByteChannel readChannel = Channels.newChannel(input);
		channel.transferFrom(readChannel, 0, Integer.MAX_VALUE);
	}
	
	public void memoryMapping(FileChannel fc) throws IOException {
		MappedByteBuffer mb = fc.map(MapMode.READ_ONLY, 0, Integer.MAX_VALUE);
	}
	
	public void reading(FileInputStream fi) throws IOException {
		//1.
		FileChannel fc = fi.getChannel();
		//2.
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//3.
		fc.read(buffer);
	}
	
	public void writing(FileOutputStream fo, byte[] msg) throws IOException {
		FileChannel fc = fo.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		for (int i = 0; i < msg.length; i++) {
			buffer.put(msg[i]);
		}
		buffer.flip();
		fc.write(buffer);
	}

}
