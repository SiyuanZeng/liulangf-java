/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.java7;

/**
 * http://openjdk.java.net/projects/lambda/
 * http://cr.openjdk.java.net/~briangoetz/lambda/lambda-state-3.html
 * 
 * JSR 335 (Lambda Expressions for the JavaTM Programming Language) aims to support programming in a 
 * multicore environment by adding closures and related features to the Java language.
 * 
 * JSR 335 is part of JSR 337 (Java SE 8), which is scheduled for release in late 2012. 
 * An Early Draft Review of JSR 335 is anticipated by September 2011.
 *
 * @author Quqing Liu
 */
public class ProjectLambda {
	
	/**
	 * A set of in-progress language changes:(Syntax subject to change!)
	 * <ul>
	 *   <li>Lambda expressions(closures)
	 *       { String x -> x.length() == 0 }</li>
	 *   <li>SAM conversion(Single Abstract Method)
	 *       Predicate<String> p = { String x -> x.length() == 0 }</li>
	 *   <li>More type inference, e.g. lambda formals
	 *       Predicate<String> p = { x -> x.length() == 0 }</li>
	 *   <li>Method references
	 *       Predicate<> p = String->isEmpty </li>
	 *   <li>Exception transparency(Maybe)</li>
	 *   <li>Virtual extension methods(aka defender methods)</li>
	 * </ul>
	 * 
	 * PS: 
	 * aka = also known as
	 */
	void project_lambda() {
		
	}
	
	/**
	 * The Java programming language already has a form of closures: anonymous inner classes. 
	 * There are a number of reasons these are considered imperfect closures, primarily:
	 * <ul>
	 *   <li>Bulky syntax</li>
	 *   <li>Inability to capture non-final local variables</li>
	 *   <li>Transparency issues surrounding the meaning of return, break, continue, and 'this'</li>
	 *   <li>No nonlocal control flow operators</li>
	 * </ul>
	 * 
	 */
	void backGround() {
	}

	/**
	 * The biggest pain point for anonymous inner classes is bulkiness. To call a method taking a CallbackHandler, 
	 * one typically creates an anonymous inner class:
	 */
	void pain() {
		
		//The anonymous inner class here is what some might call a "vertical problem": 
		//five lines of source code to encapsulate a single statement.
		this.doSomething(new CallbackHandler() {
			public void callback(Context c) {
				System.out.println("Call back.");
			}
		});
	}
	
	/**
	 * Lambda expressions are anonymous functions, aimed at addressing the "vertical problem" by replacing 
	 * the machinery of anonymous inner classes with a simpler mechanism. One way to do that would be to 
	 * add function types to the language, but this has several disadvantages:
	 * <ul>
	 *   <li>Mixing of structural and nominal types;</li>
	 *   <li>Divergence of library styles (some libraries would continue to use callback objects, while others would use function types).</li>
	 *   <li>Generic types are erased, which would expose additional places where developers are exposed to erasure. 
	 *     For example, it would not be possible to overload methods m(T->U) and m(X->Y), which would be confusing.</li> 
	 * </ul>
	 * 
	 */
	void lambda_expressions() {}
	
	void doSomething(CallbackHandler callback) {
		callback.callback(getContext());
	}
	
	Context getContext() {
		return null;
	}
}

interface Context{}
/**
 * The standard way for Java APIs to define callbacks is to use an interface representing the callback method.
 * 
 * The CallbackHandler interface has a useful property: it has a single abstract method. 
 * Many common interfaces and abstract classes have this property, such as Runnable, Callable, EventHandler, or Comparator. 
 * We call these classes SAM types. This property, SAM-ness, is a structural property identified by the compiler, 
 * as is not represented in the type system.
 * 
 * Ps:
 * SAM = Single Abstract Method
 */
interface CallbackHandler {
	void callback(Context c);
}
