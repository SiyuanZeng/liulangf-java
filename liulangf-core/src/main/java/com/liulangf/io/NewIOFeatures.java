package com.liulangf.io;


/**
 * JSR 51: NIO in Java 1.4
 * JSR 203: NIO.2 in Java 7
 * 
 * import java.io.*;
 * import java.nio.*;
 * import java.nio.channels.*;
 * import java.nio.channels.spi.*;
 * import java.nio.charset.*;
 * import java.nio.charset.spi.*;
 * 
 * http://docs.oracle.com/javase/6/docs/technotes/guides/io/index.html
 * http://docs.oracle.com/javase/1.4.2/docs/guide/nio/
 * http://docs.oracle.com/javase/6/docs/technotes/guides/io/enhancements.html
 * 
 * The new I/O (NIO) APIs introduced in v 1.4 provide new features and improved performance in 
 * the areas of buffer management, scalable network and file I/O, character-set support, and regular-expression matching.
 * 
 * The NIO APIs include the following features:
 * <ul>
 *   <li>Buffers for data of primitive types</li>
 *   <li>Character-set encoders and decoders</li>
 *   <li>A pattern-matching facility based on Perl-style regular expressions</li>
 *   <li>Channels, a new primitive I/O abstraction</li>
 *   <li>A file interface that supports locks and memory mapping</li>
 *   <li>A multiplexed, non-blocking I/O facility for writing scalable servers</li>
 * </ul> 
 * 
 * @author liulangf
 */
public class NewIOFeatures {
	
	/**
	 * 
	 * API Specification
	 *   java.io -   
	 *       Supports system input and output, object serialization, and basic access to the file system
	 *   java.nio -  
	 *       Defines buffers for bulk memory operations. Buffers may be allocated in direct memory for high performance.
	 *   java.nio.channels - 
	 *       Defines channels, an abstraction for devices capable of performing I/O operations; defines selectors for multiplexed, non-blocking I/O
	 *   java.nio.channels.spi - 
	 *       Provides implementations for channels
	 *   java.nio.charset - 
	 *       Defines charsets, decoders, and encoders, for translating between bytes and Unicode characters
	 *   java.nio.charset.spi - 
	 *       Provides implementations for charsets
	 */
	public void javaIOAPISpecifiaction() {
	}
	
	/**
	 * The central abstractions of the NIO APIs are:
	 * <ul>
	 *   <li>Buffers, which are containers for data;</li> 
	 *   <li>Charsets and their associated decoders and encoders, which translate between bytes and Unicode characters;</li>
	 *   <li>Channels of various types, which represent connections to entities capable of performing I/O operations; and</li>
	 *   <li>Selectors and selection keys, which together with selectable channels define a multiplexed, non-blocking I/O facility.</li>
	 * </ul>
	 */
	public void javaNIOPackage() {
	}

	/**
	 * Use NIO When You Need To:
	 * <ul>
	 *   <li>Move large amounts of data efficiently</li>
	 *   <li>Multiplex large numbers of open sockets</li>
	 *   <li>Use OS-level file locking or memory mapping</li>
	 *   <li>Do character set Transcoding</li>
	 * </ul>
	 */
	public void useNIOWhenYouNeedTo() {
	}

	/**
	 * What makes Up NIO
	 * <ul>
	 *   <li>Buffer</li>
	 *   <li>Channel</li>
	 *   <li>Selector</li>
	 *   <li>Regular Expression</li>
	 *   <li>Character Set Coding</li>
	 * </ul>
	 */
	public void whatMakesUpNIO() {
	}
	
}
