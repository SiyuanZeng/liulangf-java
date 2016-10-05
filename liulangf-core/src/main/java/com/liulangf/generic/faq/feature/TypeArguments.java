/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.feature;

import java.util.Collections;
import java.util.List;

/**
 * Generic types and methods have formal type parameters, which are replaced by actual type arguments 
 * when the parameterized type or method is instantiated.
 * 
 * A reference type or a wildcard that is used for instantiation of a generic type or a reference type
 * used for instantiation of a generic method.
 * 
 * @author LiuYuqing
 *
 */
public class TypeArguments {
	
	/**
	 * There are a couple of rules for type arguments:
	 * <ul>
	 *   <li>The actual type arguments of a generic type are</li>
	 *       <li>reference type</li>
	 *       <li>wildcard</li>
	 *       <li>parameterized types(i.e. instantiations of other generic types)</li>
	 *   <li>Generic methods cannot be instantiated using wildcards as actual type arguments</li>
	 *   <li>Type parameters are permitted as actual type arguments</li>
	 *   <li>Primitive types are not permitted as type arguments.</li>
	 *   <li>Type arguments must be within bounds.</li>
	 * </ul>
	 * 
	 */
	public void rulesForTypeArguments() {
		class SomeClass<T> {
			public List<T> someMethod() {
				List<T> list = Collections.<T>emptyList();
				return list;
			}
			
			public <S> void anotherMethod(S arg) {
				//Type parameters as type arguments.
				List<S> list = Collections.<S>emptyList();
			}
		}
	}

}
