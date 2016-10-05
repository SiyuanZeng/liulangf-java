package com.liulangf.io;

/**
 * <ul>
 *  <li>Perl 5-ish syntax</li>
 *  <li>New CharSequence interface in java.lang</li>
 *  <li>Pattern and Matcher objects</li>
 *  <li>String class has regex convenience methods added</li>
 * </ul>
 * 
 * @author liulangf
 */
public class NIORegularExpressions {
	
	/**
	 * Implemented by String, StringBuffer and CharBuffer
	 */
	interface CharSequence {
		int length();
		char charAt(int index);
		CharSequence subSequence(int start, int end);
		public String toString();
	}

}
