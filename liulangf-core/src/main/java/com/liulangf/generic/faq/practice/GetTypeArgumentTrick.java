/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.practice;

/**
 * A technique for recovering the type argument from a wildcard parameterized type at run-time.
 * 
 * A reference of a wildcard type typically refers to a concrete parameterization of the corresponding generic type,
 * e.g. a List<?> refers to a LinkedList<String>. Yet it is impossible to retrieve the concrete parameterization's type
 * argument from the wildcard type. The getTypeArgument trick solves this problem and enables you to retrieve the 
 * type argument dynamically at run-time.
 * 
 * Wildcard capture.
 * 
 * @author LiuYuqing
 */
public class GetTypeArgumentTrick {

}

interface GenericType<T> {
	//The method takes the type variable as an argument.
	void method(T arg);
	Class<T> getTypeArgument();
}

class ConcreteType implements GenericType<String> {
	public void method(String arg) {
	}
	public Class<String> getTypeArgument() {
		return String.class;
	}
}

class GenericUsage {
	private GenericType<?> reference;
	public void method(Object object) {
		//reference.method(object);
		helper(reference, object);
	}
	
	private static <T> void helper(GenericType<T> reference, Object arg) {
		reference.method(reference.getTypeArgument().cast(arg));
	}
	
}