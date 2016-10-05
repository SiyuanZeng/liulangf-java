/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.practice;

/**
 * A way to recover the type of the this object in a class hierarchy.
 * See <<Java Generics and Collections>> by Maurice Naftalin and Philp Wadler.
 * It is a way to recover the type of the this object - a recovery of type information that is
 * sometimes needed in class hierarchies with a self-referential generic supertype.
 * 
 * Examples of self-referential generic types:
 *   abstract class Enum<E extends Enum<E>>
 *   abstract class Node<N extends Node<N>>
 *   abstract class TaxPayer<P extends TaxPayer<P>>
 *   
 * Self-referential generic types are often used to express in a supertype that its subtypes depend on themselves.
 * 
 * @author LiuYuqing
 */
public abstract class GetThisTrick<T extends GetThisTrick<T>> {
    private SomeOtherType<T> ref;
    
    /**
     * Or naming as self();
     * this === GetThisTrick<T>.
     * 
     * The problem is that the this reference is of type GetThisTrick<T> , while the method m expects 
     * an argument of type T , which is a subtype of type GetThisTrick<T> . 
     * 
     * @return
     */
    protected abstract T getThis();
    
    public void trick() {
    	ref.m(getThis());
    	ref.m((T)this);
    }
}
interface SomeOtherType<E> {
	void m(E arg);
}
class SubType extends GetThisTrick<SubType> {
	//???The "getThis" trick provides a way to recover the exact type of the this reference. 
	public SubType getThis() {
		return this;
	}
}