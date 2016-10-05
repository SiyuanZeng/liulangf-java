package com.liulangf.exception;

/**
 * http://today.java.net/pub/a/today/2003/12/04/exceptions.html
 * Exceptions are a tremendous debugging aid because they help answer these three questions:
 * <ul>
 * <li>What went wrong?</li>
 * <li>Where did it go wrong?</li>
 * <li>Why did it go wrong?</li>
 * </ul>
 * 
 * <p>
 * When exceptions are used effectively, what is answered by the type of exception thrown, 
 * where is answered by the exception stack trace, and why is answered by the exception message. 
 * If you find your exceptions aren't answering all three questions, chances are they aren't being 
 * used effectively. 
 * <p>
 * Three rules will help you make the best use of exceptions when debugging your programs. These rules are: 
 * <ul>
 * <li>be specific</li>
 * <li>throw early</li>
 * <li>catch late</li>
 * </ul>
 * @author YuQing Liu
 */
public interface Three_Rules_for_Effective_Exception_Handling {
	
	void be_specific();
	
	/**
	 * The exception stack trace helps pinpoint where an exception occurred by showing us the exact sequence 
	 * of method calls that lead to the exception, along with the class name, method name, source code filename, 
	 * and line number for each of these method calls.
	 */
	void throw_early();

}
