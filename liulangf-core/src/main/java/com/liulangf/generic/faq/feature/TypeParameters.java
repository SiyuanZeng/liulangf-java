/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.feature;

/**
 * @author LiuYuqing
 *
 */
public class TypeParameters {
	
	/**
	 * Specification of a bound has two effects:
	 * <ul>
	 *   <li>It gives access to the methods that the bound specifies.</li>
	 *   <li>Only types "within bounds" can be used for instantiation of the generic type.</li>
	 * </ul>
	 * 
	 * The syntax for specification of type parameter bounds is :
	 * <TypeParameter extends class & interface1 & ... & interfaceN>
	 * 
	 * The bound of the type parameter:
	 * All classes, interfaces and enum types including parameterized types, but no primitive types and no array types.
	 * 
	 * A bound that is a class gives access to all its public members. Only constructors are not made accessible.
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public <T extends Comparable<T>> int boundedTypeParameter(T t1, T t2) {
		return t1.compareTo(t2);
	}
	
	/**
	 * How do I decrypt "Enum<E extends Enum<E>>"?
	 * 
	 * As a type that can only be instantiation for its subtype, and those subtype will inherit some useful methods,
	 * some of which take subtype arguments(or otherwise depend on the subtype);
	 * 
	 * The type Enum is the common base class of all enumeratioin types. The purpose of the superclass Enum is to 
	 * provide functionality that is common to all enumeration types.
	 * 
	 * The newly defined class Enum and its newly defined type parameter E appear in the bound of the same type parameter.
	 * It means that the Enum type must be instantiated for one of its subtype.
	 * 
	 * Such as :
	 *   enum Color extends Enum<Color> 
	 * It makes sure that only subtypes of type Enum are permitted as type arguments.
	 * 
	 * To sum it up, the declaration "Enum<E extends Enum<E>>" can be decyphered as: Enum is a generic type that
	 * can only be instantiated for its subtypes, and those subtypes will inherit some useful methods, some of which
	 * take subtype specific arguments(or otherwise depend on the subtype).
	 */
	public void decryptSelfBound() {
	}
	
	/**
	 * Type parameters can be used for typing(like non-generic classes and interfaces)::
	 * <ul>
	 *   <li>as argument and return types of methods</li>
	 *   <li>as type of a field or local reference variable</li>
	 *   <li>as type argument of other parameterized types</li>
	 *   <li>as target type in casts</li>
	 *   <li>as explicit type argument of parameterized methods</li>
	 * </ul>
	 * 
	 * Type parameters can NOT be used for the following purposes(different from non-generic classes and interfaces)::
	 * <ul>
	 *   <li>for creation of objects</li>
	 *   <li>for creation of arrays</li>
	 *   <li>in exception handling</li>
	 *   <li>in static context</li>
	 *   <li>in instanceof expressions</li>
	 *   <li>as supertype</li>
	 *   <li>in a class literal</li>
	 * </ul>
	 * 
	 * Type parameters can appear in throws clauses, but not in catch clauses.
	 */
	public void usageOfTypeParameter() {
	}
	
	/**
	 * Everywhere in the definition of a generic type or method, except any static context of a type.
	 */
	public void visibilityOfTypeParameter() {
	}

}
