package com.liulangf.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Loading classpath resources in java.
 * classpath file liulangf.properties ==> 
 * 1. ClassLoader.getResourceAsStream("com/liulangf/util/liulangf.properties");
 * 2. Class.getResourceAsStream("/com/liulangf/util/liulangf.properties");
 * 3. Class.getResourceAsStream("liulangf.properties");
 * 4. ResourceBundle.getBundle("com.liulangf.util.liulangf.properties");
 * 
 * @author LiuYuQing
 * @version 1.0 2010-7-5
 */
public class ResourceUtils {
	
	static class ClassPather {
		//Class.getResource("liulangf.properties");
		public InputStream gerResource(String name) throws IOException {
			URL url = getClass().getResource(name);
			if (url != null) {
				return url.openStream();
			}
			
			throw new IOException("File not found.");
		}
		
		//ClassLoader.getResource("com/liulangf/util/liulangf.properties");
		public InputStream getResource2(String name) throws IOException {
			URL url = getClass().getClassLoader().getResource(name);
			if (url != null) {
				return url.openStream();
			}
			throw new IOException("File not found.");
		}
		
		//Class.getResourceAsStream("liulangf.properties");
		//Class.getResourceAsStream("/com/liulangf/util/liulangf.properties");
		public InputStream getInputStream(String name) {
			return getClass().getResourceAsStream(name);
		}
		
		//ClassLoader.getResourceAsStream("com/liulangf/util/liulangf.properties");
		public InputStream getInputStream2(String name) {
			return getClass().getClassLoader().getResourceAsStream(name);
		}
	}
	
	public static void load(InputStream resource) throws IOException {
		Properties props = new Properties();
		props.load(resource);
		System.out.println(props.get("name"));
		System.out.println(props.get("mobile"));
	}
	
	public static void main(String... args) throws IOException {
		ClassPather cp = new ClassPather();
		load(cp.gerResource("liulangf.properties"));
		load(cp.getResource2("com/liulangf/util/liulangf.properties"));
		
		load(cp.getInputStream("liulangf.properties"));
		load(cp.getInputStream("/com/liulangf/util/liulangf.properties"));
		
		load(cp.getInputStream2("com/liulangf/util/liulangf.properties"));
		//load(cp.getInputStream2("/com/liulangf/util/liulangf.properties"));
	}
	

}
