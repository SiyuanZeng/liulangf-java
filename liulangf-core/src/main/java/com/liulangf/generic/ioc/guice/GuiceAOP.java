package com.liulangf.ioc.guice;

/**
 * Wherever you see similar code scattered throughout the code base that does not contribute 
 * to the actual business logic, that code is a possible target for AOP.
 * 
 * 
 * @author liulangf
 *
 */
public class GuiceAOP {

	/**
	 * AOP is usually about doing work before or after (or both) a piece of code executes 
	 * in your application. To be able to do that without modifying your code, Guice AOP 
	 * generates proxies (impersonators, if you will) for your targeted objects.
	 * 
	 * Guice AOP is all about intercepting method calls using proxy.
	 * 
	 */
	void how_guice_aop_works() {
	}

	/**
	 * <ul>
	 *   <li>Use the Matchers class to match specific classes or methods.</li>
	 *   <li>Use binder.bindInterceptor in a Module to point MethodInterceptor instances to all the matches</li>
	 *   <li>Remember that Guice AOP only works for objects Guice creates!</li>
	 * </ul>
	 * 
	 */
	void summary() {
	}

}
