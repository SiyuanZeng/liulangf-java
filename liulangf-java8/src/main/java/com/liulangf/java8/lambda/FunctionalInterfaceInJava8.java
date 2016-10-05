package com.liulangf.java8.lambda;


/**
 * <<The Java Language Specification Java SE 8>> 9.8 Functional Interfaces
 * 
 * A functional interface is an interface that has just one abstract method (aside
 * from the methods of Object), and thus represents a single function contract.
 * 
 * Instances of functional interfaces can be created with 
 *   1. method reference expressions 
 *   2. and lambda expressions. 
 */
public interface FunctionalInterfaceInJava8 {

	/**
	 * Everything in java has a type 				=>
	 * 
	 * Problem: Need types to represent Functions 	=>
	 * 
	 * Solution: Use interface  					=>
	 * 
	 * ====> functional interface
	 * 
	 */
	void why_functional_interfaces();
	
	/**
	 * SAM: single abstract method
	 * 
	 * Functional interfaces that have just 1 method.
	 */
	void single_abstract_method();
	
	/**
	 * You can think of method reference forms as shorthand for the other lambda forms:
	 * 
	 *  Method reference   =>  Equivalent lambda express
	 *  String::valueOf         x -> String.valueOf(x);
	 *  Object::toString        x -> x.toString()
	 *  x::toString             () -> x.toString()
	 *  ArrayList::new			() -> new ArrayList()
	 */
	void method_reference_and_lambda_expression();
}
