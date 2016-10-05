package com.liulangf.io.charset.chinese;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuQing Liu
 *
 */
public class ChineseHelloWorld {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(ChineseHelloWorld.class);
	
	public static void main(String...args) throws UnsupportedEncodingException {
		//Charset cu = Charset.forName("unicode");
		//System.out.println(cu.displayName());
		new ChineseHelloWorld().getBytes();
	}
	
	void getBytes() throws UnsupportedEncodingException {
		//Unicode string
		String chinese = "中文";
		//encode
		byte[] b_gbk = chinese.getBytes("GBK");
		byte[] b_utf8 = chinese.getBytes("UTF-8");
		byte[] b_iso8859 = chinese.getBytes("ISO-8859-1");
		byte[] b_unicode = chinese.getBytes("unicode");
		byte[] b_gb2312 = chinese.getBytes("gb2312");
		
		LOGGER.info("GBK [{}]", b_gbk.length);
		LOGGER.info("utf-8 [{}]", b_utf8.length);
		LOGGER.info("iso-8859-1 [{}]", b_iso8859.length);//2
		LOGGER.info("utf-16 [{}]", b_unicode.length);
		LOGGER.info("gb2312 [{}]", b_gb2312.length);
		
		//decode
		String s_gbk = new String(b_gbk, "GBK");
		String s_utf8 = new String(b_utf8, "UTF-8");
		String s_iso8859 = new String(b_iso8859, "ISO-8859-1");//error
		String s_unicode = new String(b_unicode, "unicode");
		String s_gb2312 = new String(b_gb2312, "gb2312");
		
		LOGGER.info("GBK [{}]", s_gbk);
		LOGGER.info("UTF8 [{}]", s_utf8);
		LOGGER.info("iso-8859-1 [{}]", s_iso8859);//error
		LOGGER.info("utf-16 [{}]", s_unicode);
		LOGGER.info("gb2312 [{}]", s_gb2312);
		
		iso8859_chinese();
		iso8859_GBK();
		iso8859_gb2312();
	}
	
	/**
	 * ISO-8859-1 is single byte encoding schema.
	 * 
	 * @throws UnsupportedEncodingException
	 */
	void iso8859_chinese() throws UnsupportedEncodingException {
		String chinese = "中文";
		byte[] b_utf8 = chinese.getBytes("UTF-8");       //using utf-8 encode
		String s_8859 = new String(b_utf8, "iso-8859-1");//using iso-8859-1 decode
		byte[] b_8859 = s_8859.getBytes("iso-8859-1");   //using iso-8859-1 encode
		String s_utf = new String(b_8859, "UTF-8");      //using utf-8 decode
		LOGGER.info("iso-8859-1 to utf8 [{}]", s_utf);
	}
	
	void iso8859_GBK() throws UnsupportedEncodingException {
		String chinese = "中文";
		byte[] b_gbk = chinese.getBytes("GBK");
		String s_8859 = new String(b_gbk, "iso-8859-1");
		byte[] b_8859 = s_8859.getBytes("iso-8859-1");
		String s_gbk = new String(b_8859, "GBK");
		LOGGER.info("iso-8859-1 to gbk [{}]", s_gbk);
	}
	
	void iso8859_gb2312() throws UnsupportedEncodingException {
		String chinese = "中文";
		byte[] b_gb2312 = chinese.getBytes("gb2312");
		String s_8859 = new String(b_gb2312, "iso-8859-1");
		byte[] b_8859 = s_8859.getBytes("iso-8859-1");
		String s_gb2312 = new String(b_8859, "gb2312");
		LOGGER.info("iso-8859-1 to gb2312 [{}]", s_gb2312);
	}

}
