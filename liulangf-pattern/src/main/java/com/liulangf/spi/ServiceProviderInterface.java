package com.liulangf.spi;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

/**
 * http://en.wikipedia.org/wiki/Service_provider_interface
 * http://java.sun.com/developer/technicalArticles/javase/extensible/
 * 
 * Service Provider Interface (SPI) is a software mechanism to support replaceable components. 
 * It is the implementer-side equivalent of an API; a set of hooks that can or must be overridden.
 * 
 * From Java official documentation: 
 * "A service is a well-known set of interfaces and (usually abstract) classes. 
 * A service provider is a specific implementation of a service. 
 * The classes in a provider typically implement the interfaces and subclass the classes defined in the service itself.
 * Service providers can be installed in an implementation of the Java platform in the form of extensions, 
 * that is, jar files placed into any of the usual extension directories. 
 * Providers can also be made available by adding them to the application's class path 
 * or by some other platform-specific means."
 * 
 * The concept can be easily extended to any other platform using the corresponding tools.
 * 
 * In the Java Runtime Environment, SPIs are used in JDBC, JCE, JNDI, JAXP, JBI, Java Sound and Java Image I/O.
 * 
 * Official Java API documentation: java.util.ServiceLoader class and java.util.spi package
 *
 * @author Quqing Liu
 */
public class ServiceProviderInterface {

	public void loading() {
		//META-INF/services/com.example.CodecSet
		ServiceLoader<MyService> myServiceLoader = ServiceLoader.load(MyService.class);
		MyService mine = myServiceLoader.iterator().next();
		System.out.println(mine.getClass());
		mine.doSomething();
	}
	
	public void loadingUrls() {
		//URL[] urls = {file.toURI().toURL()};
		URL[] urls = new URL[] {};
		ClassLoader classLoader = new URLClassLoader(urls);
		ServiceLoader<MyService> services = ServiceLoader.load(MyService.class, classLoader);
	}
	
	public static void main(String... args) {
		new ServiceProviderInterface().loading();
	}
}
