package com.liulangf.io.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CharsetNutshell {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(CharsetNutshell.class);
	
	/**
	 * Charsets map glyphs(symbols) to numeric codes.
	 * Charsets are represented by character encodings(actual bits and bytes that are stored in files).
	 * Fonts must support charsets in order to display texts in respective encodings properly.
	 */
	class CharsetAndEncoding {
		
		/**
		 * Glyph(symbol) : A
		 * Numeric code  : 65               (ASCII charset)
		 * Encoding      : 0x41 == 100001 b (ASCII 7-bit encoding)
		 */
		void example() {}
	}

	/**
	 * Unicode (UCS, ISO-10646)
	 * Unicode defines standardized numeric codes (code points) for most glyphs used in the world.
	 */
	class Unicode {
		//Code points are abstract- they don't define representation.
		void codePoint(){}
	}

	/**
	 * Define representation of code points in bits and bytes.
	 * UCS, UTF
	 */
	class UnicodeEncoding{
		/**
		 * UTF:Unicode Transformation Format
		 * UTF-8: variable size from 1 - 6 bytes
		 * UTF-16:
		 * 
		 *  A Unicode transformation format (UTF) is an algorithmic mapping from every Unicode code point 
		 *  (except surrogate code points) to a unique byte sequence
		 */
		class UTF {
			
			/**
			 * char and String are UTF-16
			 * Encoding conversions are built-in:
			 *   Encoded text is binary data for java, therefor stored in bytes.
			 *   s.toBytes(...) - encodes a String
			 *   new String(...) - decodes raw bytes to a String.
			 */
			void inJava() {}
		}
	}

	/**
	 * <ul>
	 *   <li>Character set</li>
	 *   <li>Coded character set(Charset)</li>
	 *   <li>Character-encoding scheme(UTF-8, UTF-16)</li>
	 * </ul>
	 */
	public void terms() {
	}
	
	/**
	 * java.nio.charsets.Charset
	 *   Encapsulates a coded character set and the encoding scheme used to represent a sequence of 
	 *   characters from that character set as a byte sequence.
	 * java.nio.charsets.CharsetEncoder
	 *   An encoding engine that converts a sequence of characters into a sequence of bytes. 
	 *   The byte sequence can later be decoded to reconstitute the original character sequence.
	 * java.nio.charsets.CharsetDecoder
	 *   A decoding engine that converts an encoded byte sequence into a sequence of characters.
	 * java.nio.charsets.CharsetProvider
	 *   Used by the service provider mechanism to locate and make Charset implementations available 
	 *   to use within the runtime environment.
	 */
	public void packageInfo() {
	}
	
	public static void main(String... args) {
		SortedMap<String, Charset> available = Charset.availableCharsets();
		for (String key : available.keySet()) {
			LOGGER.info("{} -> {}", key, available.get(key).displayName());
		}
		LOGGER.info("==The default charset is [{}].==", Charset.defaultCharset().displayName());
	}

}
