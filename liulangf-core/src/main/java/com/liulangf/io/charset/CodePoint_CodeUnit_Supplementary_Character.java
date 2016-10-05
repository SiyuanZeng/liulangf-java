package com.liulangf.io.charset;

/**
 * http://java.sun.com/javase/technologies/core/basic/intl/faq.jsp#text-representation
 * 
 * A coded character set is a character set (a collection of characters) where each character has been assigned a unique number. 
 * At the core of the Unicode standard is a coded character set that assigns the letter "A" the number 004116 and the letter "€" 
 * (the symbol for the euro currency) the number 20AC16. The Unicode standard always uses hexadecimal numbers, and writes them 
 * with the prefix "U+", so the number for "A" is written as "U+0041".
 * 
 * @author YuQing Liu
 *
 */
public class CodePoint_CodeUnit_Supplementary_Character {
	
	/**
	 * Code points are the numbers that can be used in a coded character set. 
	 * A coded character set defines a range of valid code points, but doesn't 
	 * necessarily assign characters to all those code points. The valid code points 
	 * for Unicode are U+0000 to U+10FFFF. Unicode 4.0 assigns characters to 96,382 
	 * of these more than a million code points.
	 */
	void code_point() {}
	
	/**
	 * Supplementary characters are characters with code points in the range U+10000 to U+10FFFF, 
	 * that is, those characters that could not be represented in the original 16-bit design of Unicode. 
	 * The set of characters from U+0000 to U+FFFF is sometimes referred to as the Basic Multilingual Plane (BMP). 
	 * Thus, each Unicode character is either in the BMP or a supplementary character.
	 */
	void supplementary_character() {}
	
	/**
	 * A character encoding scheme is a mapping from the numbers of one or more coded character sets 
	 * to sequences of one or more fixed-width code units. The most commonly used code units are 8-bit bytes, 
	 * but 16-bit or 32-bit integers can also be used for internal processing. UTF-32, UTF-16, and UTF-8 are 
	 * character encoding schemes for the coded character set of the Unicode standard.
	 */
	void character_encoding_schema() {}
	
	/**
	 * A character encoding is a mapping from a set of characters to sequences of code units. 
	 * They apply a character encoding scheme to one or more coded character sets. Some commonly 
	 * used character encodings are UTF-8, ISO-8859-1, GB18030, Shift_JIS.
	 */
	void character_encoding() {}
	
	/**
	 * A Unicode code unit is a 16-bit char value. 
	 * <p>
	 * For example, imagine a String that contains the letters "abc" followed by the Deseret LONG I,
	 *  which is represented with two char values. That string contains four characters, four code points, 
	 *  but five code units.
	 */
	void code_unit() {}
	
	/**
	 * To support supplementary characters without changing the char primitive data type and causing 
	 * incompatibility with previous Java programs, supplementary characters are defined by a pair of 
	 * code point values that are called surrogates. The first code point is from the high surrogates 
	 * range of U+D800 to U+DFBB, and the second code point is from the low surrogates range of U+DC00 
	 * to U+DFFF. For example, the Deseret character LONG I, U+10400, is defined with this pair of 
	 * surrogate values: U+D801 and U+DC00.
	 */
	void surrogates() {}
	
	/**
	 * Unicode code point:   U+0041   U+00DF    U+6771     U+10400 
	 * Representative glyph:   A         ß        東                                 𐐀
	 * UTF-32 code units:    00000041 000000DF  00006771   00010400
 	 * UTF-16 code units:      0041    00DF      6771      D801 DC00
	 * UTF-8 code units:       41     (C3 9F) (E6 9D B1) (F0 90 90 80)
	 * 
	 */
	void comparison() {
		System.out.println("\u00df\u6771\ud801\udc00");
		char[] codeUnits = Character.toChars(0x10400);
		System.out.println(new String(codeUnits));
	}
	
	public static void main(String...args) {
		new CodePoint_CodeUnit_Supplementary_Character().comparison();
	}
	
}
