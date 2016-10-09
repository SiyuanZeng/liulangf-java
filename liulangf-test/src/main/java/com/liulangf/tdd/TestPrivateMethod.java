package com.liulangf.tdd;

/**
 * 
 * 
 * @author YuQing Liu
 *
 */
public class TestPrivateMethod {
	
	/**
	 * The best way to test a private method is via another public method. If this cannot be done, then one of the following conditions is true:
	 *     The private method is dead code
	 *     There is a design smell near the class that you are testing
	 *     The method that you are trying to test should not be private
	 */
	public void a() {}

	/**
     * The solutions for testing private methods usually fall into 4 categories:
     * <ul>
     *   <li>Don't test private methods</li>
     *   <li>Use reflection</li>
     *   <li>Use a nested class</li>
     *   <li>Change the visibility</li>
     * </ul>
	 */
	public void b() {}
	

}
