package com.liulangf.refactor.smell;

/**
 * @author YuQing Liu
 *
 */
public class SmellsWithinClasses {
	
	/**
	 * Should only be used to clarify "why" not "what".
	 * Can quickly become verbose and reduce code clarity.
	 * 
	 * Refactoring:
	 *   Extract Method
	 *   Rename Method
	 *   Introduce Assertion
	 */
	void comments() {}
	
	/**
	 * The longer the method the harder it is to see what it is doing.
	 * 
	 * Refactoring:
	 *   Extract Method
	 *   Replace Temp with Query
	 *   Introduce Parameter Object
	 *   Preserve Whole Object
	 *   Replace Method with Method Object
	 */
	void longMethod() {}
	
	/**
	 * Don't pass in everything the method needs; pass in enough so that the method can get to everything it needs.
	 * 
	 * Refactoring:
	 *   Replace Parameter with Method
	 *   Preserve Whole Object
	 *   Introduce Parameter Object
	 */
	void longParameter() {}
	
	/**
	 * Refactoring:
	 *   Extract Method
	 *   Pull Up Field
	 *   Form Template Method
	 *   Substitute Algorithm
	 */
	void duplicatedCode() {}
	
	/**
	 * A class that is trying to do too much can usually be identified by looking at how many instance variables it has. 
	 * When a class has too many instance variables, duplicated code cannot be far behind.
	 * 
	 * Refactoring:
	 *   Extract Class
	 *   Extract Subclass
	 */
	void largeClass() {}
	
	/**
	 * Avoid redundancy in naming. Prefer schedule.add(course) to schedule.addCourse(course)
	 * 
	 * Refactoring:
	 *   Rename Method
	 */
	void typeEmbeddedInName() {}

	/**
	 * Choose names that communicate intent (pick the best name for the time, change it later if necessary).
	 * 
	 * Refactoring:
	 *   Rename Method
	 * 
	 */
	void uncommunicativeName() {}
	
	/**
	 * Use names consistently.
	 * 
	 * Refactoring:
	 *   Rename Method
	 * 
	 */
	void inconsistentNames() {}
	
	/**
	 * A variable, parameter, method, code fragment, class, etc is not used anywhere (perhaps other than in tests).
	 * 
	 * Refactoring:
	 *   Delete the code
	 */
	void deadCode() {}
	
	/**
	 * Don't over-generalize your code in an attempt to predict future needs.
	 * 
	 * Refactoring:
	 *   If you have abstract classes that aren't doing much use Collapse Hierarchy
	 *   Remove unnecessary delegation with Inline Class
	 *   Methods with unused parameters - Remove Parameter
	 *   Methods named with odd abstract names should be brought down to earth with Rename Method
	 */
	void speculativeGenerality() {}
}
