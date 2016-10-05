package com.liulangf.io.buffer;

import java.nio.ByteBuffer;

public class BufferFactory {
	
	
	public ByteBuffer create(int index) {
		switch(index) {
		case 0: return ByteBuffer.allocate(10);
		case 1: return ByteBuffer.wrap("hello".getBytes());
		case 2: return ByteBuffer.wrap("hello".getBytes(), 0, 1);
		}
		
		return null;
	}

}
