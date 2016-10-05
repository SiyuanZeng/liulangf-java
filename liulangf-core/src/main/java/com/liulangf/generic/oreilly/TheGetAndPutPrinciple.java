/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.oreilly;

import java.util.Arrays;
import java.util.List;

/**
 * The Get and Put Principle: 
 * use an extends wildcard when you only get values out of a structure, 
 * use a super wildcard when you only put values into a structure, 
 * and don't use a wildcard when you both get and put.
 *
 * @author Quqing Liu
 */
public class TheGetAndPutPrinciple {

	/**
	 * The quizzical phrase 
	 * ? super T means that the destination list may have elements of any type that is a supertype of T, 
	 * just as the source list may have elements of any type that is a subtype of T.
	 * 
	 * @param <T>
	 * @param dst
	 * @param src
	 */
	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dst.set(i, src.get(i));
		}
	}
	
	/**
	 * too restrictive, as it only permits calls when the destination and source have exactly the same type.
	 */
	public static <T> void copy1(List<T> dst, List<T> src) {}
	
	//works only when the type parameter is Object
	public static <T> void copy2(List<T> dst, List<? extends T> src) {
		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
	}
	
	//works only when the type parameter is Integer
	public static <T> void copy3(List<? super T> dst, List<T> src) {
		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
	}
	
	public static void usage() {
		//Object is the super Type
		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
		//T => Integer
		TheGetAndPutPrinciple.copy(objs, ints);
		assert objs.toString().equals("[5, 6, four]");
		
		TheGetAndPutPrinciple.copy(objs, ints);
		TheGetAndPutPrinciple.<Object>copy(objs, ints);  //T => Object
		TheGetAndPutPrinciple.<Number>copy(objs, ints);  //T => Number  : List<Object> is a subtype of List<? super Number> 
		TheGetAndPutPrinciple.<Integer>copy(objs, ints); //T => Integer : List<Integer> is a subtype of List<? extends Number>
		
		//works only when the type parameter is Object
		TheGetAndPutPrinciple.<Object>copy2(objs, ints);
		//works only when the type parameter is Integer
		TheGetAndPutPrinciple.<Integer>copy3(objs, ints);
	}

}
