/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.feature;

import java.util.List;

/**
 * Wildcard: A syntactic construct that denotes a family of types.
 * 
 * A wildcard describes a family of types. There are 3 different flavors of wildcards:
 * <ul>
 *   <li>? - the unbounded wildcard. It stands for the family of all types.</li>
 *   <li>? extends Type - a wildcard with an upper bound. It stands for the family of all types that are subtypes of Type.</li>
 *   <li>? super Type - a wildcard with a lower bound. It stands for the family of all types that are supertypes of Type.</li>
 * </ul>
 * 
 * Wildcards are used to declare so-called wildcard parameterized types, where a wildcard is used as an argument for
 * instantiation of generic types. Wildcards are useful in situations where no or only partial knowledge about the type
 * argument of a parameterized type is required.
 * 
 * @author LiuYuqing
 */
public class Wildcards {
	
	/**
	 * A wildcard with either an upper or a lower bound.
	 * <? extends T> - read-only
	 * <? super T>   - write-only
	 * 
	 * Bounded wildcards are useful in situations where only partial knowledge about the type argument of a 
	 * parameterized type is needed, but where unbounded wildcards carry too little type information.
	 * 
	 */
	public <T> void boundedWildcard(List<? super T> dest, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dest.set(i, src.get(i));
		}
	}
	
	/**
	 * Bounded wildcards carry more information than unbounded wildcards. While an unbounded wildcard stands for a 
	 * representative from the family of all types, a bounded wildcards stands for a representative of a family of ither
	 * super- or subtypes of a type. Hence a bounded wildcard carries more type information than an unbounded wildcard.
	 * The supertype of such a family is called the upper bound, the subtype of such a family is called the lower bound.
	 * 
	 */
	public void conclusion() {
	}

	/**
	 * A wildcard can have only one bound, while a type parameter can have several bounds.
	 * A wildcard can have a lower or an upper bound, while where is no such thing as a lower bound for a type parameter.
	 */
	public void differenceBetweenAWildcardBoundAndTypeParameterBound() {
		class Box<T extends Comparable<T> & Cloneable> implements Comparable<Box<T>>, Cloneable {
			private T theObject;
			public Box(T arg) {
				this.theObject = arg;
			}
			public Box(Box<? extends T> box) {
				this.theObject = box.theObject;
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Comparable#compareTo(java.lang.Object)
			 */
			@Override
			public int compareTo(Box<T> arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			/* (non-Javadoc)
			 * @see java.lang.Object#clone()
			 */
			@Override
			protected Box<T> clone() throws CloneNotSupportedException {
				return null;
			}
		}
	}

}














