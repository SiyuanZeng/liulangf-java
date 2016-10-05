/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.creational.factory_method;

/**
 * <<Effective Java2>> Chapter2,Item1
 *
 * @author Quqing Liu
 */
public class StaticFactoryMethod {
	
	//Here are some common names for static factory methods:
	
	/**
	 * Returns an instance that has, loosely speaking, the same value as its parameters.
	 * Such static factories are effectively type-conversion methods.
	 */
	public static void valueOf() {
	}
	
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	/**
	 * A concise alternative to valueOf, popularized by EnumSet
	 */
	public static void of() {
	}
	
	public static void getInstance() {
	}
	
	public static void newInstance() {
	}
	
	public static void getType() {
	}
	
	public static void newType() {
	}
	

}
