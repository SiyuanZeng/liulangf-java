package com.liulangf.exception;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>Log and Throw</li>
 * <li>Throwing java.lang.Exception</li>
 * <li>Throwing the Kitchen Sink</li>
 * <li>Catch java.lang.Exception</li>
 * <li>Log and Return null</li>
 * <li>Catch and Ignore</li>
 * <li>Throw from within Finally</li>
 * <li>Multi-line Log Messages</li>
 * <li><Unsupported Operation Returning null/li>
 * <li>Ignoring InterruptedException</li>
 * <li>Relying on getCause()</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class Exception_Handling_Antipatterns {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("serial")
	class MyException extends Exception {}
	@SuppressWarnings("serial")
	class YourException extends Exception { 
		public YourException(String message) {
			super(message);
		}
	}
	
	void hello() throws MyException {
		throw new MyException();
	}
	
	/**
	 * This is one of the most annoying error-handling antipatterns. 
	 * Either log the exception, or throw it, but never do both. 
	 * Logging and throwing results in multiple log messages for a single problem 
	 * in the code, and makes life hell for the support engineer who is trying to 
	 * dig through the logs.
	 * 
	 * @throws MyException
	 */
	void log_and_throw() throws MyException {
		try {
			hello();
		} catch (MyException e) {
			logger.error("", e);
			//or
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This is just sloppy, and it completely defeats the purpose of using a checked exception. 
	 * It tells your callers "something can go wrong in my method." Real useful. Don't do this. 
	 * Declare the specific checked exceptions that your method can throw. If there are several, 
	 * you should probably wrap them in your own exception.
	 * @throws Exception
	 */
	void throw_exception() throws Exception {}
	
	/**
	 * kitchen_sink = too many.
	 * 
	 * <pre>
	 *     public void foo() throws MyException, 
	 *             AnotherException, 
	 *             SomeOtherException, 
	 *             YetAnotherException {
	 *     }
	 * </pre>
	 * 
	 * Throwing multiple checked exceptions from your method is fine, as long as there are different 
	 * possible courses of action that the caller may want to take, depending on which exception was thrown. 
	 * If you have multiple checked exceptions that basically mean the same thing to the caller, wrap them 
	 * in a single checked exception.
	 */
	void throwing_the_kitchen_sink() {}
	
	/**
	 * This is generally wrong and sloppy. Catch the specific exceptions that can be thrown. 
	 * The problem with catching Exception is that if the method you are calling later adds a new checked exception 
	 * to its method signature, the developer's intent is that you should handle the specific new exception. 
	 * If your code just catches Exception (or worse, Throwable), you'll probably never know about the change 
	 * and the fact that your code is now wrong.
	 */
	void catching_exception() {
		try {
			hello();
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	/**
	 * This destroys the stack trace of the original exception, and is always wrong.
	 */
	void destructive_wrapping() throws YourException {
		try {
			hello();
		} catch (MyException e) {
			throw new YourException("This is wrong" + e.getMessage());
		}
	}
	
	/**
	 * Although not always incorrect, this is usually wrong. Instead of returning null, throw the exception, 
	 * and let the caller deal with it. You should only return null in a normal (non-exceptional) use case 
	 * (e.g., "This method returns null if the search string was not found.").
	 * 
	 * @return
	 */
	Object log_and_return_null() {
		try {
			hello();
			return new Object();
		} catch (MyException e) {
			e.printStackTrace();
			//or
			logger.error("", e);
			return null;
		}
	}
	
	/**
	 * This one is insidious. Not only does it return null instead of handling or re-throwing the exception, 
	 * it totally swallows the exception, losing the information forever.
	 * @return
	 */
	Object catch_and_ignore() {
		try {
			hello();
		} catch (MyException e) {
			return null;
		}
		return new Object();
	}
	
	/**
	 * This is fine, as long as cleanUp() can never throw an exception. In the above example, if blah() throws an exception, 
	 * and then in the finally block, cleanUp() throws an exception, that second exception will be thrown and the first exception 
	 * will be lost forever. If the code that you call in a finally block can possibly throw an exception, make sure that you either 
	 * handle it, or log it. Never let it bubble out of the finally block.
	 */
	void throw_from_within_finally() {
		try {
			//blah();
		} finally {
			//cleanUp();
		}
	}
	
	/**
	 * Always try to group together all log messages, regardless of the level, into as few calls as possible. So in the example above, 
	 * the correct code would look like:
	 *     logger.debug("Using cache policy A, using retry policy B");
	 * 
	 * Using a multi-line log message with multiple calls to log.debug() may look fine in your test case, but when it shows up in the 
	 * log file of an app server with 500 threads running in parallel, all spewing information to the same log file, your two log messages 
	 * may end up spaced out 1000 lines apart in the log file, even though they occur on subsequent lines in your code.
	 */
	void multi_line_log_message() {
		logger.debug("Using cache policy A");
		logger.debug("Using retry policy B");
	}
	
	String unsupported_operation_returning_null() {
		//throw new UnsupportedOperationException();
		return null;
	}
	
	/**
	 * InterruptedException is a clue to your code that it should stop whatever it's doing. Some common use cases for a thread getting 
	 * interrupted are the active transaction timing out, or a thread pool getting shut down. Instead of ignoring the InterruptedException, 
	 * your code should do its best to finish up what it's doing, and finish the current thread of execution. 
	 */
	void ignoring_interruptedException() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {}
			//doSomethingCool();
		}
	}
	
	//So to correct the example above:
	void dont_ignoring_interruptedException() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				break;
			}
			//doSomethingCool();
		}
	}
	
	/**
	 * The problem with relying on the result of getCause is that it makes your code fragile. It may work fine today, 
	 * but what happens when the code that you're calling into, or the code that it relies on, changes its underlying 
	 * implementation, and ends up wrapping the ultimate cause inside of another exception? Now calling getCause may 
	 * return you a wrapping exception, and what you really want is the result of getCause().getCause(). Instead, you 
	 * should unwrap the causes until you find the ultimate cause of the problem. 
	 * Apache's commons-lang project provides ExceptionUtils.getRootCause() to do this easily.
	 * 
	 */
	void relying_on_getCause() {
		try {
			hello();
		} catch (Exception e) {
			if (e.getCause() instanceof MyException) {
				//...
			}
		}
	}
}
