package com.liulangf.principle;

/**
 * http://pragprog.com/articles/tell-dont-ask
 * 
 * @author YuQing Liu
 *
 */
public class Tell_Dont_ask {
	
	/**
	 * Alec Sharp, in the recent book Smalltalk by Example, 
	 * points up a very valuable lesson in few words:
	 *    1. Procedural code gets information then makes decisions. 
	 *    2. Object-oriented code tells objects to do things.
	 */
	void by_Alec_Sharp() {}
	
	/**
	 * To ask is a query, to tell is a command.
	 */
	void command_query_separation() {}
	
	/**
	 * http://www.bradapp.com/docs/demeter-intro.html
	 * The Law of Demeter tries to restrict class interaction in order to minimize coupling among classes.
	 * 
	 * What that means is that the more objects you talk to, the more you run the risk of getting broken 
	 * when one of them changes.
	 * 
	 * In fact, according to the Law of Demeter for Methods, any method of an object should only call methods belonging to:
	 * <ul>
	 *   <li>itself</li>
	 *   <li>any parameters that were passed in to the method</li>
	 *   <li>any objects it created</li>
	 *   <li>any composite objects</li>
	 * </ul>
	 */
	void law_of_demeter() {}
	
	/**
	 * <pre>
	 *   SortedList thingy = someObject.getEmployeeList();
	 *   thingy.addElementWithKey(foo.getKey(), foo);
	 * </pre>
	 * 
	 * This is what we are trying to prevent. Direct access of a child like this extends 
	 * coupling from the caller farther than it needs to be. 
	 * The caller is depending on these facts:
	 * <ul>
	 *   <li>someObject holds employees in a SortedList</li>
	 *   <li>SortedList's add method is addElementWithKey()</li>
	 *   <li>foo's method to query its key is getKey()</li>
	 * </ul>
	 * 
	 * Instead, this should be:
	 * <pre>
	 *   someObject.addToThingy(foo);
	 * </pre>
	 * 
	 * Now the caller is only depending on the fact that it can add a foo to thingy, 
	 * which sounds high level enough to have been a responsibility, not too dependent on implementation
	 * 
	 */
	void example() {}

}
