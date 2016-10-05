package com.liulangf.tdd.junit;

/**
 * http://threeriversinstitute.org/TwoMoreImplementationPatterns.htm
 * Nested Method Objects and Conditional Factory helped simplify code in JUnit and make it more flexible.
 * 
 * @author YuQing Liu
 *
 */
public class Two_more_patterns {
	
	/**
	 * The Method Object implementation pattern suggests turning a 
	 * complex method into an object to enable further simplification.
	 */
	void method_object() {}
	
	/**
	 * The key was to have a chain of method objects.
	 */
	void nested_method_object() {}
	
	void conditional_factory() {}
}
