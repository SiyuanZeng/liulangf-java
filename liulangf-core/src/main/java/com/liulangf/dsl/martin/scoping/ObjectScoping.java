/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.scoping;

/**
 * Place the DSL script so that bare references will resolve to a single object.
 * 
 * A further advantage of using Object Scoping is that it may support extensibility. 
 * If the DSL framework makes it easy to use a subclass of the scoping class, 
 * the user of DSL can add their own DSL methods to the language.
 * 
 * @author Quqing Liu
 */
public class ObjectScoping {
	
	/**
	 * Nested Function and (to an extent) Function Sequence may provide a nice DSL syntax, 
	 * but in their basic forms they come with a serious cost: 
	 *   global functions and (worse) global state.
	 */
	void problem(){}
	
	/**
	 * Object Scoping alleviates these problems by resolving all bare calls to a single object 
	 * and this avoids cluttering the global namespace with global functions, allowing you to 
	 * store any parsing data within this host object. The most common way to do this is to write 
	 * the DSL script inside a subclass of a builder that defines the functions—this allows the 
	 * parsing data to be captured in that one object.
	 */
	void object_scoping() {}
	
	/**
	 * One of the many useful properties of objects is that each object provides a contained scope for 
	 * functions and data. Inheritance allows you to use this scope separately from where it's defined. 
	 * A DSL can use this facility by defining DSL functions on a base class, and then allowing developers 
	 * to write DSL programs in subclasses. The base class can also define fields to hold any parsing data 
	 * that's required.
	 * 
	 * Using a base class like this is an obvious place for an Expression Builder. 
	 * Clients then write DSL programs in a subclass of the Expression Builder. 
	 * Using inheritance allows them to add other DSL functions in the subclass, or even override base functions 
	 * in the DSL object if they need to.
	 */
	void how_it_works() {}
	
}
