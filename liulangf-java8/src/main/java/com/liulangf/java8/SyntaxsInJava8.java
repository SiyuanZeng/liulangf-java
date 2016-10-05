package com.liulangf.java8;

import java.util.Arrays;
import java.util.function.Function;

public class SyntaxsInJava8 {
	
	
	/**
	 * Alonzo Church: an expression with parameter variables has been called a lambda expression.
	 * 
	 * A lambda expression is a block of code with parameters.
	 * Lambda expressions can be converted to functional interfaces.
	 * 
	 * () -> ....;
	 * () -> { ... };
	 * (Object a, Object b) -> ......;
	 */
	void lambda() {
		Function o = (Object a) -> { return null; } ;
	}

	/**
	 * object::instanceMethod
	 * Class::staticMethod
	 * Class::instanceMethod
	 * 
	 * Just like lambda expressions, method references are always turned
	 * into instances of functional interfaces.
	 * 
	 * The structure that creates a lambda from a method is called a “method reference.”
	 */
	void methodReferences() {
		String[] aaa = {};
		Arrays.sort(aaa, String::compareToIgnoreCase);
		
		//(String str) -> {return int;}
		
//	    public int compareToIgnoreCase(String str) {
//	        return CASE_INSENSITIVE_ORDER.compare(this, str);
//	    }
	}
	
	/**
	 * ClassName::new
	 */
	void constructorReferences() {
	}
	
	@FunctionalInterface
	interface FunctionalInterface2 {
		public String morning();
		
		default public String good() {
			return "";
		}
	}

}
