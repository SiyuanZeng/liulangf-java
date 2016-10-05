/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic;

/**
 * The Oxford English Dictionary defines reify thus: "To convert mentally into a thing; to materialize." 
 * A plainer word with the same meaning is thingify. 
 * 
 * In computing, reification has come to mean an explicit representation of a type, that is, run-time type information. 
 * In Java, arrays reify information about their component types,
 * while generic types do not reify information about their type parameters.
 *
 * @author Quqing Liu
 */
public class Reification {
	
	/**
	 * In Java, we say that a type is reifiable if the type is completely represented at runtime that is, 
	 * if erasure does not remove any useful information. 
	 * To be precise, a type is reifiable if it is one of the following:
	 * <ul>
	 *   <li>A primitive type (such as int)</li>
	 *   <li>A non-parameterized class or interface type (such as Number, String, or Runnable)</li>
	 *   <li>A parameterized type in which all type arguments are unbounded wildcards (such as List<?>, ArrayList<?> or Map<?, ?>)</li>
	 *   <li>A raw type (such as List, ArrayList, or Map)</li>
	 *   <li>An array whose component type is reifiable (such as int[], Number[], List<?>[], List[], or int[][])</li>
	 * </ul>
	 * 
	 * A type is not reifiable if it is one of the followsing:
	 * <ul>
	 *   <li>A type variable (such as T)</li>
	 *   <li>A parameterized type with actual parameters (such as List<Number>, Map<String, Integer>)</li>
	 *   <li>A parameterized type with a bound (such as List<? extends Number> or Comparable<? super String>)</li>
	 * </ul>
	 * 
	 * So the type List<? extends Object> is not reifiable, even though it is equivalent to List<?>.
	 * Defining reifiable types in this way makes them easy to identify syntactically.
	 */
	public void reifiableTypes() {
	}
	
	/**
	 * Instance tests and casts depend on examining type at run time, and hence depend on reification.
	 * For this reason, an instance test against a type that is not reifiable reports an error, and 
	 * a cast to a type that is not reifiable usually issues a warning.
	 */
	public void instanceTestsAndCasts() {
		
	}
	
}
