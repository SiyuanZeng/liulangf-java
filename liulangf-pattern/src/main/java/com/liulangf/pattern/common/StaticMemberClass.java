package com.liulangf.pattern.common;

import java.util.AbstractSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <<Effective Java2>> Item22
 * Favor static member classes over nonstatic.
 * @author Quqing Liu
 */
public class StaticMemberClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaticMemberClass.class);
	private String name;
	private static String parent = "parent";
	
	/**
	 * A nested class is a class defined within another class. 
	 * A nested class should exist only to serve its enclosing class.
	 * <P>
	 * There are four kinds of nested classes:
	 * <ul>
	 *   <li>static member classes</li>
	 *   <li>non-static member classes</li>
	 *   <li>anonymous classes</li>
	 *   <li>local classes</li>
	 * </ul>
	 * All but the first kind are known as inner classes.
	 */
	class NestedClass {
	}
	
	/**
	 * A static member class is a static member of its enclosing class and obeys the same 
	 * accessibility rules as other static members.
	 * 
	 * One common use of a static member class is as a public helper class, 
	 * useful only in conjunction with its outer class.
	 * 
	 * A common use of private static member classes is to represent components of the 
	 * object represented by their enclosing class.   
	 *
	 */
	public static class StaticMemberClasses {
		public void hello() {
			//static member classes can only access static fields of enclosing class.
			LOGGER.info("Can only access static fields.", parent);
		}
	}
	
	/**
	 * Each instance of a non-static member class is implicitly associated with an enclosing instance of its containing class.
	 * Within instance methods of a non-static member class, you can invoke methods on the enclosing instance or obtain a  reference 
	 * to the enclosing instance using the qualified this construct.
	 * 
	 *  The association between a non-static member class instance and its enclosing instance is established 
	 *  when the former is created; it cannot be modified thereafter.
	 *  
	 *  Normally, the association is established automatically by invoking a non-static member class constructor 
	 *  from within an instance method of the enclosing class.
	 *  
	 *  One common use of a non-static member class is to define an Adapter that allows an instance of the outer class 
	 *  to be viewed as an instance of some unrelated class.
	 */
	public class NonStaticMemberClasses {
		
		//Typical use of non-static member class.
		class MySet<E> extends AbstractSet<E> {
			
			//Factory for the non-static member class
			public Iterator<E> iterator() {
				return new MyIterator();
			}
			
			public int size() {
				return 0;
			}
			
			private class MyIterator implements Iterator<E> {

				@Override public boolean hasNext() {
					return false;
				}

				@Override public E next() {
					return null;
				}

				@Override public void remove() {
				}
			}
		}
	}
	
	interface Command {
		void execute();
	}
	
	public void invoke(Command command) {
		command.execute();
	}
	
	/**
	 * One common use of anonymous classes is to create function objects one the fly.
	 * Another common use of anonymous classes is to create process objects, such as Runnable, Thread, or TimerTask instances.
	 * A third common use is within static factory methods.
	 */
	public void helloAnonymousClass() {
		invoke(new Command() {
			public void execute() {
				
			}
		});
	}

}
