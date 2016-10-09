package com.liulangf.generic;

/**
 * Self-bounding takes the extra step of forcing the generic to be used as its own bound argument.
 * 
 * The self-bounding constraint serves only to force the inheritance relationship. 
 * If you use self-bounding, you know that the type parameter used by the class will 
 * be the same basic type as the class that’s using that parameter. 
 * It forces anyone using that class to follow that form.
 * 
 * Self-referential generic types are often used to express in a supertype that its subtypes depend on themselves.
 *
 * @author Quqing Liu
 */
public class SelfBounded<T extends SelfBounded<T>> {

	T element;
	
	SelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}
	
	T get() {
		return element;
	}
}

//This forces you to pass the class that you are defining as a parameter to the base class.
class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
	
}
