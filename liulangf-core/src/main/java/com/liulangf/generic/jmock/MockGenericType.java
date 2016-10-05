package com.liulangf.generic.jmock;

import org.jmock.Mockery;

/**
 * <<jMock Cookbook>>
 * http://www.jmock.org/mocking-generic-types.html
 * 
 * Java's generic type system does not work well with its dynamic reflection APIs. 
 * For jMock, this means that the compiler will warn you about possible static type errors when you mock generic types. 
 * The warnings are incorrect. 
 * The best way to avoid them is to suppress the warning with an annotation on the variable declaration of the mock object.
 *
 * @author Quqing Liu
 */
public class MockGenericType {
	
	/**
	 * See Mockery.mock(Class<T> clazz); for more details.
	 */
	void mock() {
		Mockery context = new Mockery();
		//However, that is not syntactically correct Java. You actually have to write the following:
		//Juicer<Orange> oJuicer = context.mock(Juicer<Orange>.class, "orangeJuicer");
		@SuppressWarnings("unchecked")
		Juicer<Orange> orangeJuicer = context.mock(Juicer.class, "orangeJuicer");
		orangeJuicer.toString();
	}

}

interface Fruit {}
interface Liquid {}
interface Juicer<T extends Fruit> {
	Liquid juice(T fruit);
}
interface Orange extends Fruit {}
interface Coconut extends Fruit {}