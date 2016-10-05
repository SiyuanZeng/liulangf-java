package com.liulangf.java8.lambda;

/**
 * A lambda expression has three ingredients:
 * <ul>
 *   <li>A block of code</li>
 *   <li>Parameters</li>
 *   <li>Values for the free variables, that is, 
 *       the variables that are not parameters 
 *       and not defined inside the code.</li>
 * </ul>
 */
public class LambdaInJava8 {
	
	/**
	 * When values of free variables are passed to lambda express,
	 * we say that these values have been captured by the lambda expression.
	 */
	void capturedByTheLambdaExpression() {}
	
	/**
	 * The technical term for a block of code together with the values of
	 * the free variables is a closure.
	 */
	void closure() {}

	public static void main(String...args) {
		Runnable r = () -> { 
			System.out.println("Good");
			System.out.println("morning!");
		};
		
		r.run();
	}
}


