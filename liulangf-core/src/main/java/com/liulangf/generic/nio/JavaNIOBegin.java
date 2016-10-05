package com.liulangf.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaNIOBegin {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	public void trySyntax(InputStream in1, InputStream in2, InputStream in3, InputStream in4) throws IOException {
		try (InputStream i1 = in1; InputStream i2 = in2; InputStream i3 = in3; InputStream i4 = in4) {
		}
	}
	
	public void channels(InputStream in) {
		ReadableByteChannel channel = Channels.newChannel(in);
	}
	
	public void dump(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try (ReadableByteChannel sc = src; WritableByteChannel dc = dest) {
			while (sc.read(buffer) != -1) {
				buffer.flip();
				dc.write(buffer);
				buffer.clear();
			}
		}
	}
	
	public void watching() {
		Path dir = Paths.get(".");
		log.info("Watching the current dir...");
		try (WatchService watcher = dir.getFileSystem().newWatchService()) {
			dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			
			while (true) {
				WatchKey watchKey = watcher.take();
				List<WatchEvent<?>> events = watchKey.pollEvents();
				events.stream().forEach(event -> {
					log.info("{}", event.context().toString());
				});
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * charset，一个用来转换不同字符编码的包。在NIO之前，Java通过getByte方法内置实现了大部分相同的功能。
	 * charset很受欢迎，因为它比getBytes更加灵活，并且能够在更底层去实现，这样就能够获得更好的性能。
	 * 这个对于搜索那些对于编码、顺序以及其他语言特点比较敏感的非英语语言而言更加有价值。
	 * 
	 * 注意Charset和通道被设计成能够放在一起进行使用，这样就能够使得程序在内存映射、异步I/O以及编码转换进行协作的时候，能够正常运行。
	 * @throws CharacterCodingException 
	 */
	public void charsetApi() throws CharacterCodingException {
		String some_string = "This is a string that Java natively stores as Unicode."; 
		 Charset latin1_charset = Charset.forName("ISO-8859-1"); 
		 CharsetEncoder latin1_encoder = latin1_charset.newEncoder(); 
		 ByteBuffer latin1_bbuf = latin1_encoder.encode(CharBuffer.wrap(some_string));
		
	}

}
