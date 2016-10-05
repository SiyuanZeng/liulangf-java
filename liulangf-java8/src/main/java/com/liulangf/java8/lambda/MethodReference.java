package com.liulangf.java8.lambda;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/**
 * The structure that creates a lambda from a method is called a “method reference.”
 * 
 * :: -> The compiler will look into the signature of that method and perform type inference, 
 * constructing the appropriate interface implementation for you.
 * 
 */
public class MethodReference {
	
	void method_reference() {
		//static method
		IntFunction<String> intToString = Integer::toString;
		ToIntFunction<String> parseInt = Integer::valueOf;
		
		//constructor
		Function<String,BigInteger> newBigInt = BigInteger::new;
		
		//instance method
		Consumer<String> print = System.out::println;
		UnaryOperator<String> makeGreeting = "Hello, "::concat;
		IntFunction<String> lookup = Arrays.asList("a","b","c")::get;
		IntSupplier randomInt = new Random()::nextInt;
	}
	
	public IntUnaryOperator compareAgainst(Integer compareLeft) {
		return compareLeft::compareTo;
	}

}
