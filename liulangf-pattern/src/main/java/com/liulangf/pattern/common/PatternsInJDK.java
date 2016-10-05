package com.liulangf.pattern.common;

/**
 * http://blog.rajgad.com/work/software-development/2009-02/design-patterns-in-java-jdk-and-java-frameworks.html
 * 
 * 
 * @author liulangf
 *
 */
public class PatternsInJDK {
	
	/**
	 * Any method which creates an objects, initializes it and returns it. socket.getInputStream(), 
	 * Executors.newFixedThreadPool(), Collections.singleton(), etc
	 */
	void factory_pattern() {}
	
	/**
	 * Used to traverse collections. Collection.getIterator()
	 */
	void iterator_pattern() {}
	
	/**
	 * Use to wrap\convert Streams adding functionality to them. 
	 * Not Adapter pattern due to added functionality. 
	 * Wrap a FileInputStream into a Reader and use .readLine() to read lines.
	 */
	void decorator_pattern() {}
	
	/**
	 * The streams as above, the Streams chained handle the request and pass it after operating on it. 
	 * Criteria, an alternative to HQL in Hibernate.
	 */
	void chain_of_responsibility_pattern() {}
	
	/**
	 *  Concrete strategies to implement family of algorithms which are interchangeable. 
	 *  All collections are strategies, accessible using a common interface, depending what what is stored, 
	 *  Map interface can be HashMap, TreeMap, LinkedHashMap.
	 */
	void strategy_pattern() {}
	
	/**
	 * Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. 
	 * java.util.AbstractCollection expects iterator, size, add and provides 
	 * addAll, clear, contains, containsAll, isEmpty, remove, etc.
	 */
	void template_method_pattern() {}
	
	/**
	 * Java Security Manager, System.getSecurityManager(); Socket accept and other permissions
	 */
	void singleton_pattern() {}
	
	/**
	 * Has a Cloneable marker interface, which indicates to Object.clone() that it is legal\safe to make a field copy. 
	 * Should not be done for open files, self-allocated memory, ….
	 */
	void prototype_pattern() {}
	
	/**
	 * Built in support in JDK including Observer interface & Observable classes.
	 */
	void observer_pattern() {}

}
