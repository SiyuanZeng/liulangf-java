package com.liulangf.tdd.junit;

/**
 * http://www.threeriversinstitute.org/blog/?p=155
 * <<JUnit in action, 2nd>>. Appendix B.
 * 
 * @author LiuYuqing
 *
 */
public class Interceptors_in_JUnit {
	
	/**
	 * The Interceptor pattern can be described as a method that intercepts a business 
	 * method invocation.The pattern usually consists of several objects.The first one is
	 * an Interceptor interface that defines one or more methods that your interceptors
	 * will implment. The next is a Delegate object that holds a list of interceptors.
	 * The Delegate object is called at the intercepting points of your application, ant
	 * it invokes the interceptors one after another.
	 * 
	 * Features of Interceptor pattern:
	 * <ul>
	 * <li>It propagates extensibility and flexibility.</li>
	 * <li>It enables separation of concerns.</li>
	 * <li>In increases reusability.</li>
	 * <li>If not used properly, security issues might occur.</li>
	 * </ul>
	 */
	void interceptor_pattern() {}
	
	void before_after_pattern() {}

	
}

/**
 * http://bosy.dailydev.org/2007/04/interceptor-design-pattern.html
 * http://www.blogjava.net/DLevin/archive/2012/05/12/377955.html
 *
 */
interface Interceptor {
	void interceptBefore();
	void interceptAfter();
}

