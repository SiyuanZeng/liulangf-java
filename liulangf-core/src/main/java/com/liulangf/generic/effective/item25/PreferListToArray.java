/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.effective.item25;

/**
 * <<Effective Java2>> item 25: Prefer lists to arrays.
 * Array differ from generic types in two important ways.
 * First, arrays are covariant (协变的). Generics, by contract, are invariant; 
 * Second, arrays are reified.
 * 
 * Arrays and generics do not mix well.
 *
 * @author Quqing Liu
 */
public class PreferListToArray {
	
	/**
	 * Arrays are covarient.
	 * This means that if Sub is a subtype of Super, then the array type
	 * Sub[] is a subtype of Super[].
	 * 
	 * Generics are invariant;
	 * List<Sub> and List<Super> have no relations.
	 * 
	 */
	public void covariant() {
	}
	
	/**
	 * Reify : 具体化
	 * Arrays are reified.
	 * This means that arrays know and enforce their element types at runtime.
	 * So, you can’t create an array of a non-reifiable type,
	 * 
	 * Types such as E, List<E>, and List<String> are technically known as non-reifiable types.
	 * A non-reifiable type is one whose runtime representation contains less information than 
	 * its compile-time representation.
	 * 
	 * The only parameterized types that are reifiable are unbounded wildcard types 
	 * such as List<?> and Map<?,?>.
	 */
	public void reified() {		
	}

}
