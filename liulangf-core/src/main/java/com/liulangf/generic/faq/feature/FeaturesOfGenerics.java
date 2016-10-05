/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.faq.feature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Java Generics support definition and use of generic types and methods. 
 * It provides language features for the following purposes:
 * <ul>
 *   <li>definition of a generic type</li>
 *   <li>definition of a generic method</li>
 *   
 *   <li>type parameters</li>
 *     <li>type parameter bounds</li>
 *     
 *   <li>type arguments</li>
 *     <li>wildcards</li>
 *     <li>wildcard bounds</li>
 *     <li>wildcard capture</li>
 *     
 *   <li>instantiation of a generic type</li>
 *     <li>raw type</li>
 *     <li>concrete instantiation</li>
 *     <li>wilccard instantiation</li>
 *     
 *   <li>instantiation of a generic method</li>
 *     <li>automatic type inference</li>
 *     <li>explicit type argument specification</li>
 * </ul>
 *  
 *
 * @author Quqing Liu
 */
public class FeaturesOfGenerics {
	
	/**
	 * All types, except enum types, anonymous inner classes and exception classes, can be generic.
	 * 
	 * <ul>
	 *   <li>Anonymous classes do not hava a name, but the name of a generic class is needed for 
	 *     declaring an instantiation of the class and providing the type arguments.</li>
	 *   <li>Exception handling mechanism is a runtime mechanism and the JVM does not know anything about generics.</li>
	 *   <li>An enum type and its enum values are static. Since type parameters cannot be used in any static context.</li>
	 * </ul>
	 * 
	 */
	public void areThereAnyTypesThatCannotHaveTypeParameters() {
	}

	/**
	 * By providing a type argument per type parameter. The result is a so-called parameterized type.
	 * 
	 * For wildcard instantiations, they do not have concrete types as type arguments, but so-called wildcards.
	 * A wildcard is syntactic constuct with a "?" that denotes not just one type, but a family of types.
	 * 
	 */
	public void howIsAGenericTypeInstantiated() {
		//Concrete parameterized type
		List<String> ls = new ArrayList<String>();
		//wildcard parameterized type
		List<? extends Number> lw = new ArrayList<Double>();
	}

	/**
	 * A wildcard parameterized type is not a concrete type that could appear in a new expression.
	 * A wildcard parameterized type is similar to an interface type in the sense that reference variable
	 * of a wildcard parameterized type can be declared, but no objects of the wildcard parameterized type
	 * can be created.
	 * 
	 * The reference variables of a wilccard parameterized type can refer to an object that is a type that 
	 * belongs to the family of types that the wildcard parameterized type denotes.
	 * 
	 * A wildcard parameterized type has no exact runtime type representation.
	 * 
	 * Wildcard parameterized types can be used for typing:
	 * <ul>
	 *   <li>as argument and return types of methods</li>
	 *   <li>as type of a field or local reference variable</li>
	 *   <li>as component type of an array</li>
	 *   <li>as type argument of other parameterized types</li>
	 *   <li>as target type in casts</li>
	 * </ul>
	 * 
	 * Wildcard parameterized type can NOT be used for the following purposes:
	 * <ul>
	 *   <li>for creation of objects</li>
	 *   <li>for creation of arrays(except <?>)</li>
	 *   <li>in exception handling</li>
	 *   <li>in instanceof expressions(except <?>)</li>
	 *   <li>as supertypes</li>
	 *   <li>in a class literal</li>
	 * </ul>
	 * 
	 */
	public void wildcardParameterizedType() {
		Collection<?> coll = new ArrayList<String>();
		List<? extends Number> list = new ArrayList<Long>();
		Comparator<? super String> cmp = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return 0;
			}
		};
	}
	
	/**
	 * The unbounded wildcard parameterized type : <?>
	 * 
	 * The raw type and <?> have a lot in common. Both act as kind of a supertype of all instantiations
	 * of the corresponding generic type. Both are so-called reifiable types.
	 * 
	 * Reifiable types can be used in instanceof expressions and as the component type of arrays.
	 *  
	 */
	public void unboundedWildcardType() {
	}
	
}
