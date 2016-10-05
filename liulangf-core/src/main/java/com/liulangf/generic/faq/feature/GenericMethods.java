/*************************************************************************
* Copyright (c) 2006-2011 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.feature;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Generic method: A method with type parameter.
 * Static and non-static methods as well as constructors can have type parameters.
 * 
 * @author LiuYuqing
 */
public class GenericMethods {
	
	/**
	 * Define a generic method.
	 * 
	 * @param <T>
	 * @param ct
	 * @return
	 */
	public <T extends Comparable<T>> T max(Collection<T> ct) {
		Iterator<T> t = ct.iterator();
		T w = t.next();
		while (t.hasNext()) {
			T x = t.next();
			if (w.compareTo(x) < 0) {
				w = x;
			}
		}
		return w;
	}
	
	/**
	 * Usually by calling it. Type arguments need not be provided explicitly; 
	 * they are almost always automatically inferred.
	 */
	public void invokeGenericMethod() {
		LinkedList<Long> list = new LinkedList<Long>();
		list.add(0L);
		list.add(8L);
		//automatically inferred
		Long m = max(list);
		
		//explicitly invoking
		m = this.<Long>max(list);
	}

	/**
	 * Which one is better: a generic method with type parameters or a non-generic method with wildcards?
	 * 
	 * It depends. There is not one-size-fits-all rule.
	 * 
	 */
	public void differenceOfGenericMethodAndNonGenericWildcardMethod() {
	}
	
	/**
	 * How do I implements a method that takes a wildcard argument?
	 * Using a generic helper method and wildcard capture.
	 * 
	 * How do I implments a method that takes a multi-level wildcard argument?
	 * Using several generic helper methods and wildcard capture.
	 *
	 *
	 */
	public void wildcardCaptureTrick() {
	}
	
}