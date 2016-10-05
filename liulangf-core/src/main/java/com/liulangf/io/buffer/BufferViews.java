package com.liulangf.io.buffer;

import java.nio.CharBuffer;

/**
 * When a buffer that manages data elements contained in another buffer is created, 
 * it's known as a view buffer. Most view buffers are views of ByteBuffers.
 * 
 * 
 * @author liulangf
 *
 */
public class BufferViews {

	
	/**
	 * View buffers are always created by calling methods on an existing buffer instance.
	 */
	public void createViewBuffer(CharBuffer cb) {
		CharBuffer view1 = cb.duplicate();
		CharBuffer view2 = cb.asReadOnlyBuffer();
		CharBuffer view3 = cb.slice();
	}
}
