package com.liulangf;

import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author LiuYuQing
 * @version 1.0 2010-6-24
 */
public class HelloTemp {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloTemp.class);
	
	private static final int COMMENT_TABLE_COUNT = 97;
	public static void main(String...args) {
		String hex = "6cdf";
		int tid = Integer.valueOf(hex, 16).intValue();
		LOGGER.info("==[{}->{}]", hex, tid);
		
		int number = 25226;
		LOGGER.info("==[{}->{}]", number, intToHex(number));
	}
	
	private static String intToHex(int number) {
		return Integer.toHexString(number);
	}
	
	public void just() {
		for (String s : new String[] {"a", "b"}) {
			s.toCharArray();
		}
	}
	
    public static String getTableNo(String x_object_id) {
        if (x_object_id == null) return null;
        int mod = x_object_id.hashCode() % COMMENT_TABLE_COUNT;
        if (mod < 0) mod = mod + COMMENT_TABLE_COUNT;
        return StringUtils.leftPad("" + mod, 3, '0');
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
	public static void sendEmail(String subject, String content) {
		String[] to = new String[] {"liuyuqing@kongzhong.com"};
		try {
			HtmlEmail sender = new HtmlEmail();
	        sender.setHostName("192.168.1.92");;
	        for (int i = 0; i < to.length; i++) {
	            sender.addTo(to[i]);
	        }
	        sender.setFrom("thrkd@kongzhong.com");
	        sender.setSubject(subject);
	        sender.setHtmlMsg(content);
	        sender.setCharset("UTF-8");
	        sender.send();
		} catch (Throwable e) {
			LOGGER.error("sendEmail Error", e);
		}
	}
    
        
}
