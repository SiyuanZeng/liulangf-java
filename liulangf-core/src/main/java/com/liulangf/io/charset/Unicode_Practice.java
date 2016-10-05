package com.liulangf.io.charset;

/**
 * @author YuQing Liu
 *
 */
public class Unicode_Practice {

	public static void main(String...args) {
		System.out.println(System.getProperty("file.encoding"));
		char shi = '\u2603';
		System.out.println(shi);
		System.out.println('\u795E');
		//\uD800-\uDBFF
		//uDC00-\uDFFF
		char[] a = new char[] {'\uD801', '\uDC01'};
		//char b = '𐐂';
		char b = '\uD801';
		char c = '\uDC01';
		System.out.println(a);
		String m = "𐐁";
		System.out.println(m.length());
		System.out.println(b);
		System.out.println(c);
		System.out.println("\uD801\uDc01");
	}
	
	/**
	 * String.charAt(i);
	 */
	public void code_point() {
		String a = "你好啊，这个是饥饿";
		for (int i = 0; i < a.length(); i++) {
			int codePoint = a.charAt(i);
			String hex = Integer.toHexString(codePoint);
			System.out.println("u" + hex);
		}
		String b = "\u4f60\u597d\u554a\uff0c\u8fd9\u4e2a\u662f\u9965\u997f";
		System.out.println(b);
	}
	
	public void printChar() {
		for (int i = 0; i < 65535; i ++) {
			if (i % 50 == 0) {
				System.out.println();
			}
			System.out.print((char)i);
			System.out.print("  ");
		}		
	}
}
