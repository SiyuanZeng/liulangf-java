/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.refactor.smell;

/**
 * @author YuQing Liu
 *
 */
public class SmellsBetweenClasses {
	
	/**
	 * Use small objects to represent data such as money (which combines quantity and currency) or a date range object
	 * 
	 * Refactoring:
	 *   Replace Data Value with Object
	 *   Replace Type Code with Class
	 *   Replace Type Code with Subclasses
	 *   Replace Type Code with State/Strategy
	 *   If you have a group of fields that should go together, use Extract Class
	 *   If the primitives occur in a param lists use Introduce Parameter Object
	 *   When working with an array consider Replace Array With Object
	 */
	void primitiveObsession() {}

	/**
	 * Classes with fields and getters and setters and nothing else (aka, Data Transfer Objects - DTO)
	 * 
	 * Refactoring:
	 *   Move in behavior with Move Method
	 */
	void dataClass() {}
	
	/**
	 * Clumps of data items that are always found together.
	 * 
	 * Refactoring:
	 *   Turn the clumps into an object with Extract Class Then continue the refactoring with 
	 *   Introduce Parameter Object or Preserve Whole Object
	 * 
	 */
	void dataClumps() {}
	
	/**
	 * Subclasses don't want or need everything they inherit.
	 * The Liskov Substitution Principle (LSP) says that you should be able to treat any subclass of a class as 
	 * an example of that class.
	 * 
	 * Refactoring:
	 *   Most of the time that's fine, just don't use what you don't need. Occassionally you'll need to create a 
	 *   new sibling class and use Push Down Method and Push Down Field 
	 *   The smell is worst if a subclass is reusing behavior but does not want to support the interface of the superclass. 
	 *   In this case use Replace Inheritance with Delegation
	 */
	void refusedBequest() {}
	
	/**
	 * Two classes are overly entertwined.
	 * 
	 * Refactoring:
	 *   Move Method 
	 *   Move Field
	 *   Change Bidirectional Association to Unidirectional Association
	 *   Extract Class
	 *   Hide Delegate
	 *   Replace Inheritance with Delegation
	 */
	void inappropriateIntimacy() {}
	
	/**
	 * Classes that aren't doing enough should be refactored away.
	 * 
	 * Refactoring:
	 *   Collapse Hierarchy
	 *   Inline Class
	 */
	void lazyClass() {}
	
	/**
	 * Often a method that seems more interested in a class other than the one it's actually in. 
	 * In general, try to put a method in the class that contains most of the data the method needs
	 * 
	 * Refactoring:
	 *   Move Method. May need to use Extract Method first, then Move Method
	 */
	void featureEnvy() {}
	
	/**
	 * This is the case in which a client has to use one object to get another, and then use that one to get to another, etc. 
	 * Any change to the intermediate relationships causes the client to have to change.
	 * 
	 * Refactoring:
	 *   Hide Delegate Or try using Extract Method and then Move Method to move it down the chain.
	 */
	void messageChains() {}
	
	/**
	 * When a class is delegating almost everything to another class, it may be time to refactor out the middle man.
	 * 
	 * Refactoring:
	 *   Remove Middle Man
	 *   If only a few methods aren't doing much, use Inline Method
	 *   You could also consider turning the middle man into a subclass with Replace Delegation with Inheritance
	 */
	void middleMan() {}
	
	/**
	 * Occurs when one class is commonly changed in different ways for different reasons. 
	 * Any change to handle a variation should change a single class.
	 * 
	 * Refactoring:
	 *   Identify everything that changes for a particular cause and use Extract Class to put them all together.
	 */
	void divergentChange() {}
	
	/**
	 * The opposite of Divergent Change. A change results in the need to make a lot of little changes in several classes.
	 * 
	 * Refactoring:
	 *   Use Move Method and Move Field to put all the changes into a single class.
	 *   Often you can use Inline Class to bring a whole bunch of behavior together.
	 */
	void shotgunSurgery() {}
	
	/**
	 * A special case of Shotgun Surgery. Every time you make a subclass of one class, 
	 * you also have to make a subclass of another.
	 * 
	 * Refactoring:
	 *   Use Move Method and Move Field to combine the hierarchies into one.
	 */
	void parallelInheritanceHierarchies() {}
}

