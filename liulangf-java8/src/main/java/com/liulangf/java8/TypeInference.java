package com.liulangf.java8;

import java.util.function.Function;


public class TypeInference {

	/**
	 * the compiler infers out the type of value based on the context in which the value is used. 
	 * This is a capability called “type inference,” and it is one of the nicest things to come out of functional programming languages.
	 * 
	 * you need to provide a way for the compiler to know the argument and return type of the function.
	 * 
	 * @return
	 */
	static <V> Function<V, V> identityFunction() {
		//value -> value : A lambda
		return value -> value;
	}
	
	static <V> Function<V, V> identityFunction2() {
		//value -> value : A lambda
		return value -> value;
	}
	
	
	
}
