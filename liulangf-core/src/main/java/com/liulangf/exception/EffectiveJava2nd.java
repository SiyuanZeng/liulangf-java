package com.liulangf.exception;

/**
 * From <<Effective java 2nd>> chapter 9.
 * 
 * <ul>
 * <li>Item 57: Use exceptions only for exceptional conditions</li>
 * <li>Item 58: Use checked exceptions for recoverable conditions and runtime exceptions for programming errors</li>
 * <li>Item 59: Avoid unnecessary use of checked exceptions</li>
 * <li>Item 60: Favor the use of standard exceptions.</li>
 * <li>Item 61: Throw exceptions appropriate to the abstraction</li>
 * <li>Item 62: Document all exceptions thrown by each method</li>
 * <li>Item 63: Include failure-capture information in detail messages</li>
 * <li>Item 64: Strive for failure atomicity</li>
 * <li>Item 65: Don't ignore exceptions</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public interface EffectiveJava2nd {
	
	/**
	 * Item 60: Favor the use of standard exceptions.
	 * <ul>
	 * <li>IllegalArgumentException</li>
	 * <li>IllegalStateException</li>
	 * <li>NullPointerException</li>
	 * <li>IndexOutOfBoundsException</li>
	 * <li>ConcurrentModificationException</li>
	 * <li>UnsupportedOperationException</li>
	 * </ul>
	 */
	void standard_exceptions();
	
	/**
	 * use
	 * if (obj == null)
	 *    //....
	 * but throw NullPointerException();
	 */
	void unchecked_exception();

}
