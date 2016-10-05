package com.liulangf.generic;

/**
 * http://passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation
 * 
 * "self types" can be emulated in Java using Generics.
 * 
 * @author liulangf
 */
public class SelfTypeWithGeneric {
	
	/**
	 * Type of this.
	 */
	void selfTypes() {}
	
	/**
	 * Return type is vital for access to fluent API methods.
	 */
	void returnType() {}
	
	interface GenericAssert<SELF_TYPE> {
		SELF_TYPE isNotNull();
	}
	
	class SimpleAssert implements GenericAssert<SimpleAssert> {
		public SimpleAssert isNotNull() {
			//This is so cool.
			return (SimpleAssert) this;
		}
	}

}
