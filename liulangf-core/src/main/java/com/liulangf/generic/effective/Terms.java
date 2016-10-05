/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.effective;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Generics allow you to abstract over types.
 * 
 * A class or interface whose declaration has one or more type parameters is a generic class or interface.
 * 
 * Generic class, Generic interface => Generic Types
 * generic methods
 * type parameter
 * formal type parameters
 * actual type parameters
 * parameterized types
 * raw type      : is not safe (You must use raw types in class literals.)
 * wildcard type : is safe
 * subtyping rules for generic
 * unbounded wildcard types : Set<?>
 * bounded wildcard types   : Set<? extends Number>
 *
 * @author Quqing Liu
 */
public class Terms {

	/**
	 * There are two minor exceptions to the rule that you should not use raw types in new code,
	 * both of which stem from the fact that generic type information is erased at runtime:
	 * 1.You must use raw types in class literals;
	 * 2.The second exception to the rule concerns the instanceof operator.
	 * 
	 */
	public void rawType() {
		Class<String> cs = String.class;
		//Class<List<String>> cl = List<String>.class;
		Class<List> cl = List.class;
		
		Object o = null;
		//This is the preferred way to use the instanceof operator with generic types:
		if (o instanceof Set) {
			Set<?> m = (Set<?>) o;
		}
	}

	/**
	 * Set<Object> is a parameterized type representing a set that can contain object of any type;
	 * Set<?> is a wildcard type representing a set than can contain only objects of some unknown type;
	 * Set is a raw type.
	 * 
	 * @param os
	 */
	public void differ(Set<?> os) {
		Set<Object> so = new HashSet<Object>();
	}
	
	
	/**
	 * 			Term   					: Example
	 * <ul>
	 *   <li>Parameterized type			: List<String> 						<li>
	 *   <li>Actual type parameter		: String 							</li>
	 *   <li>Generic type				: List<E> 							</li>
	 *   <li>Formal type parameter		: E 								</li>
	 *   <li>Unbounded wildcard type	: List<?> 							</li>
	 *   <li>Raw type					: List 								</li>
	 *   <li>Bounded type parameter		: <E extends Number> 				</li>
	 *   <li>Recursive type bound		: <T extends Comparable<T>> 		</li>
	 *   <li>Bounded wildcard type		: List<? extends Number> 			</li>
	 *   <li>Generic method				: static <E> List<E> asList(E[] a); </li>
	 *   <li>Type token					: String.class 						</li>
	 * </ul>
	 */
	public void quickReference() {
	}
	
	/**
	 * This is a generic method.
	 * 
	 * @param <E>
	 * @param a
	 * @return
	 */
	public <E> List<E> asList(E[] a) {
		return null;
	}
	
	/**
	 * This is not a generic method.
	 * 
	 * @param b
	 * @return
	 */
	public List<? extends Number> asList(Number[] b) {
		return null;
	}
	
	/**
	 * The cost of erasure is significant. Generic types cannot be used in operations that explicitly refer
	 * to runtime type, such as casts, instanceof operations, and new expressions.
	 * 
	 * Generics in Tiger is a compile-time process, and all typing information is handled at compiletime. 
	 * Once the classes are compiled, the typing information is erased (thus the term erasure). 
	 */
	public void erasure() {
	}
	
	/**
	 * Generics and Type Conversions. or .Generics and Subtyping.
	 * 
	 * The key in casting generic types is to understand that as with normal, non-generic types, the form a hierarchy.
	 * What's unique about generics, though, is that the hierarchy is based on the base type(the raw type), 
	 * not the parameters to that type. 
	 */
	public void typeConversion() {
		LinkedList<Float> floatList = new LinkedList<Float>();
		//The conversion is based on LinkedList, not Float.
		//So this is legal:
		List<Float> moreFloats = floatList;
		//However, the following is not:
		//Type mismatch: cannot convert from LinkedList<Float> to LinkedList<Number>
		//LinkedList<Number> numberLkist = floatList;
		
		//What just happened? It is because of the erasure.
		//Clearly, it needs to be the base type that is considered in type conversions, not the parameter type.
		//The raw type of List<Float> is List
		//The raw type of LinkedList<Float> is LinkedList
	}
	
}

