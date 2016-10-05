/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Quqing Liu
 */
public class GenericMethods {
	
	public static <K, V> Map<K, V> newMap() {
		return new HashMap<K, V>();
	}
	
	public <E> List<E> newList() {
		return new ArrayList<E>();
	}
	
	/**
	 * How to call generic methods
	 */
	public void explicitTypeSpecification() {
		//Compiler will infer the tpye
		Map<String, String> map1 = newMap();
		//If compile filled to infer the type, we can specify the actual type
		Map<String, Integer> map2 = GenericMethods.<String, Integer>newMap();
		List<String> list1 = this.<String>newList();
	}
	
}
