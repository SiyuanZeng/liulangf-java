/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.hood;

/**
 * 
 * @author LiuYuqing
 */
public class SomeDetails {
	
	/**
	 * Representing type parameters and arguments of generic types and methods at runtime.
	 * Reification is the opposite of type erasure.
	 * 
	 */
	public void whatIsReification() {
	}
	
	/**
	 * What is a reifiable type?
	 * A type whose type information is fully available at runtime, that is, a type that does not 
	 * lose information in the course of type erasure.
	 * 
	 * Types that do NOT lose any information during type erasure are called reifiable types.
	 * Reification means that type parameters ant type arguments of generic types and methods are available at runtime.
	 * 
	 * The following types are reifiable:
	 * <ul>
	 *   <li>primitive types</li>
	 *   <li>non-generic(or non-parameterized) reference types</li>
	 *   <li>unbounded wildcard instantiations</li>
	 *   <li>raw types</li>
	 *   <li>arrays of any of the above</li>
	 * </ul>
	 */
	public void reifiableType() {
		
	}
	
	/**
	 * Bridge method is a synthetic method that the compiler generates in the course of type erasure.
	 * It is sometimes needed when a type extends or implements a parameterized class or interface.
	 * 
	 * The compiler insert bridge methods in subtypes of parameterized supertypes to ensure that
	 * subtyping works as expected.
	 * 
	 */
	public void bridgeMethod() {
		
	}

}
