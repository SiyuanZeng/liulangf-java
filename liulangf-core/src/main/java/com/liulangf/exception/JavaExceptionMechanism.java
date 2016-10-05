package com.liulangf.exception;

/**
 * 
 * 
 * @author YuQing Liu
 *
 */
public interface JavaExceptionMechanism {
	
	/**
	 * <ul>
	 * <li>throws</li>
	 * <li>throw</li>
	 * <li>try/catch/finally</li>
	 * </ul>
	 */
	void keywords();

	/**
	 * Exceptions are unexpected conditions in programs.
	 * 
	 * <ul>
	 * <li>checked exception    Exception - RuntimeException</li>
	 * <li>unchecked exception  RuntimeException</li>
	 * <li>system error         Error</li>
	 * </ul>
	 * 
	 * java.lang.Throwable;
	 * java.lang.Exception;
	 * java.lang.Error;         //User code should never explicitly generate Errors.
	 * java.lang.RuntimeException;
	 * 
	 * Exceptions should be dealt with in a different place in the code from where they occur.
	 * So we throw exceptions where they occur, and catch them where we want to deal with them.
	 */
	void exceptions();
	
	/**
	 * Unchecked exceptions are subclasses of RuntimeException.
	 * It would be much clearer if this was called UncheckedException.
	 * 
	 * An unchecked exception indicates an unexpected problem that is probably due to 
	 * a bug in the code. The most common example is a NullPointerException. 
	 * An unchecked exception probably shouldn't be retried, and the correct response 
	 * is usually to do nothing, and let it bubble up out of your method and through the execution stack. 
	 * This is why it doesn't need to be declared in a throws clause. 
	 */
	void uncheckedException();
	
	/**
	 * Errors are serious problems that are almost certainly not recoverable. Some examples are OutOfMemoryError, 
	 * LinkageError, and StackOverflowError.
	 */
	void errors();
	
	
	/**
	 * Design by contract is about statically defining the conditions under which code is supposed to operate. 
	 *  ???? 
	 *  Unchecked exceptions are “what happens when the contract is broken”.
	 *  Checked exceptions are expected to happen from time to time, so are not contract violations. 
	 */
	void design_by_contract();
	
	/**
	 * <ul>
	 * <li>Exceptions for which the end user cannot take any useful action should be made unchecked.
	 * For example, exceptions that are fatal and unrecoverable should be made unchecked. There is no 
	 * point in making XMLParseException (thrown while parsing an XML file) checked, as the only action 
	 * to be taken may be to fix the root cause based on the exception trace. 
	 * By extending java.lang.RuntimeException, one can create custom unchecked exceptions.</li>
	 * <li>Exceptions associated with the user's actions in an application should be made checked. 
	 * Checked exceptions require the client to catch them. </li>
	 * </ul>
	 * 
	 *  You might ask why we don't make every exception unchecked. The problem might be that some of 
	 *  them may not get caught where they should be. It creates a bigger problem as errors are identified 
	 *  at runtime only. Examples of checked exceptions are business validation exceptions, security exceptions, etc.
	 */
	void guidelines_of_choosing_checked_or_unchecked_exception();
	
}
