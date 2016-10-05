package com.liulangf.io;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

/**
 * 高性能IO模型
 * http://www.cnblogs.com/fanzhidongyzby/p/4098546.html
 * 
 * @author liulangf
 *
 */
public class HelloWorldNIO {
	
	public static void main(String...args) throws Exception {
		String hello = "Hello World" + System.getProperty("line.separator");
		ByteBuffer bb = ByteBuffer.wrap(hello.getBytes("UTF-8"));
		
		WritableByteChannel wbc = Channels.newChannel(System.out);
		wbc.write(bb);
		wbc.close();
	}

}
