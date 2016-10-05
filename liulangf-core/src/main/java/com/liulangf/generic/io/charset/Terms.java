package com.liulangf.io.charset;

/**
 * http://www.unicode.org/glossary/  Unicode glossary
 * 
 * http://ietf.org/rfc/rfc2278.txt
 * rfc2278- IANA Charset Registration Procedures.
 * <ul>
 *   <li>Character set</li>
 *   <li>Coded character set      : Unicode, US-ASCII, GBK </li>
 *   <li>Character-encoding schema: Utf-8,UTF-16,ASCII, ISO-8859-1, GBK</li>
 *   <li>java.nio.charset.Charset</li>
 *   <li>Code point</li>
 *   <li>Unicode escape in java</li>
 *   <li>encode</li>
 *   <li>decode</li>
 * </ul>
 * 
 * An encoding scheme is not a character set, it's a mapping; but because of the close relationship 
 * between them, most encodings are associated with a single character set. UTF-8, for example, is used 
 * only to encode the Unicode character set. However, it's possible for one encoding scheme to handle 
 * more than one character set. For example, EUC can encode characters from several Asian languages.
 * 
 * @author YuQing Liu
 *
 */
public interface Terms {
	
	/**
	 * A character is just an abstract minimal unit of text. It doesn't have a fixed shape (that would be a glyph), 
	 * and it doesn't have a value.
	 */
	void character();
	
	void character_set();
	
	/**
	 * An assignment of numeric values to a set of characters. Assigning codes to characters 
	 * so they can be represented digitally results in a specific set of character codings. 
	 * Other coded character sets might assign a different numeric value to the same character.
	 * Character set mappings are usually determined by standards bodies, such as US-ASCII, 
	 * ISO 8859-1, Unicode (ISO 10646-1), and JIS X0201.
	 */
	void coded_character_set();
	
	/**
	 * A mapping of the members of a coded character set to a sequence of octets (eight bit bytes). 
	 * The encoding scheme defines how a sequence of character encodings will be represented as a 
	 * sequence of bytes. The numeric values of the character encodings do not need to be the same 
	 * as the encoded bytes, nor even a one-to-one or one-to-many relationship. Think of character 
	 * set encoding and decoding as similar in principle to object serialization and deserialization.
	 */
	void character_encoding_schema();
	
	/**
	 * The term charset is defined in RFC2278 (http://ietf.org/rfc/rfc2278.txt). It's the combination of 
	 * a coded character set and a character-encoding scheme. The anchor class of the java.nio.charset package 
	 * is Charset, which encapsulates the charset abstraction.
	 * 
	 */
	void java_nio_charset_Charset();
	
	/**
	 * encode - decode;
	 * byte   - char.
	 */
	void char_to_byte();
	
	/**
	 * In Unicode, a letter maps to something called a code point.
	 */
	void code_point();
	
	/**
	 * Unicode escapes can be used to include any Unicode character using only ASCII characters. 
	 */
	void unicode_escape();
	
	/**
	 * The Unicode standard defines a number of ways to represent code points as bytes. These are called encodings.
	 */
	void encoding();
}
