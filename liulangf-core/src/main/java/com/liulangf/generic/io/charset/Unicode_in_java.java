package com.liulangf.io.charset;

/**
 * <<Java Language Specification, Third edition>> chapter 3: Lexical Structure
 * Programs are written using the Unicode character set.
 * 
 * @author YuQing Liu
 *
 */
public class Unicode_in_java {
	
	/**
	 * Versions of the Java programming language prior to 1.1 used Unicode version 1.1.5. 
	 * Upgrades to newer versions of the Unicode Standard occurred in JDK 1.1 (to Unicode 2.0), 
	 * JDK 1.1.7 (to Unicode 2.1), J2SE 1.4 (to Unicode 3.0), and J2SE 5.0 (to Unicode 4.0),
	 * J2SE 6.0 (to Unicode 4.0), J2SE 7.0 (to Unicode 6.0).
	 */
	void version() {}
	
	/**
	 * http://java.sun.com/javase/technologies/core/basic/intl/faq.jsp#text-representation
	 */
	void char_Character() {}
	
	/**
	 * UTF-16 uses sequences of one or two unsigned 16-bit code units to encode Unicode code points. 
	 * Values U+0000 to U+FFFF are encoded in one 16-bit unit with the same value. Supplementary 
	 * characters are encoded in two code units, the first from the high-surrogates range (U+D800 to U+DBFF), 
	 * the second from the low-surrogates range (U+DC00 to U+DFFF). 
	 * 
	 * This may seem similar in concept to multi-byte encodings, but there is an important difference: 
	 * The values U+D800 to U+DFFF are reserved for use in UTF-16; no characters are assigned to them as code points. 
	 * This means, software can tell for each individual code unit in a string whether it represents a one-unit 
	 * character or whether it is the first or second unit of a two-unit character.
	 *  
	 * This is a significant improvement over some traditional multi-byte character encodings, where the byte 
	 * value 0x41 could mean the letter "A" or be the second byte of a two-byte character.
	 */
	void utf_16() {}
	
	/**
	 * http://weblogs.java.net/blog/2004/04/16/unicode-40-support-j2se-15
	 * <ul>
	 *   <li>char is a UTF-16 code unit, not a code point.</li>
	 *   <li>new low-level APIs use an int to represent a Unicode code point</li>
	 *   <li>high level APIs have been updated to understand surrogate pairs</li>
	 *   <li>a preference towards char sequence APIs instead of char based methods</li>
	 * </ul>
	 * 
	 */
	void unicode4_in_j2se5() {}
	
	/**
	 * In the J2SE API documentation, Unicode code point is used for character values in the range between 
	 * U+0000 and U+10FFFF, and Unicode code unit is used for 16-bit char values that are code units of the UTF-16 encoding.
	 */
	void code_unit() {}
	
	/**
	 * http://java.sun.com/developer/technicalArticles/Intl/Supplementary/
	 */
	void supplementary_character_in_java() {}
	
	void java_lang_CharSequence() {}
	
	/**
	 * The String.length() method returns the number of code units, or 16-bit char values, in the string. 
	 * If the string contains supplementary characters, the count can be misleading because it will not 
	 * reflect the true number of code points. To get an accurate count of the number of characters 
	 * (including supplementary characters), use the codePointCount method.
	 */
	void string_length() {
		String a = "\uD800\udc00\uD801\udc01\uD802\udc02";
		//==6
		System.out.println(a.length());
		//==3
		System.out.println(a.codePointCount(0, a.length()));
	}
	
}
