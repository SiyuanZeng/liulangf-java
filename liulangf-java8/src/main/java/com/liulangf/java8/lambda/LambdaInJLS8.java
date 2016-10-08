package com.liulangf.java8.lambda;


/**
 * <<The Java Language Specification Java SE 8>> 15.27 Lambda Expressions. 
 * 
 * LambdaExpression:
 *     LambdaParameters -> LambdaBody
 *     
 * 
 * Lambda expression must occure in 
 *    (1). an assignment context;
 *    (2). an invocation context;
 *    (3). a casting context.
 *    
 * Evaluation of a lambda expression produces an instance of a functional interface.
 */
public class LambdaInJLS8 {
	
	
	void helloLambda() {
		$(() -> {});
		//$(t -> {});
		//$(() -> 8);
	}

	<T extends A> void $(T a) {
	}
	
	void $(B<?> b) {
	}
	
	void $(C c) {
	}
	
	static interface A {
		void a();
	}
	
	static interface B<T> {
		void a(T t);
	}
	
	static interface C {
		int a();
	}
}
