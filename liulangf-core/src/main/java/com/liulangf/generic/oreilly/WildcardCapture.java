/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.oreilly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * When a generic method is invoked, the type parameter may be chosen to match the unknown type represented by a wildcard. 
 * This is called wildcard capture.
 *
 * @author Quqing Liu
 */
public class WildcardCapture {
	
	interface Reverser {
		
		/** Normal method with wildcard signature.
		 * The wildcard signature is slightly shorter and clearer, and is the one used in the library.
		 * 
		 * @param list
		 */
		public void reverse1(List<?> list);
		
		/**
		 * Generic method signature
		 * 
		 * @param <T>
		 * @param list
		 */
		public <T> void reverse2(List<T> list);
	}
	
	class MyReverser implements Reverser {
		
		public void reverse1(List<?> list) {
			//Wildcard capture
			reverse2(list);
		}
		
		public <T> void reverse2(List<T> list) {
			List<T> tmp = new ArrayList<T>(list);
			  for (int i = 0; i < list.size(); i++) {
			    list.set(i, tmp.get(list.size()-i-1));
			  }
		}
	}
	
	/**
	 * 2.8. Restrictions on Wildcards
	 * Wildcards may not appear at the top level 
	 * in class instance creation expressions (new), 
	 * in explicit type parameters in generic method calls, 
	 * or in supertypes (extends and implements). 
	 * 
	 */
	public void restrictionsOnWildcards() {
		// compile-time error
		//List<?> list = new ArrayList<?>();  
		//Map<String, ? extends Number> map = new HashMap<String, ? extends Number>(); 

		//Only top-level parameters in instance creation are prohibited from containing wildcards. 
		//Nested wildcards are permitted. Hence, the following is legal:
		List<List<?>> lists = new ArrayList<List<?>>();
		lists.add(Arrays.asList(1,2,3));
		lists.add(Arrays.asList("four","five"));
		assert lists.toString().equals("[[1, 2, 3], [four, five]]");
	}

}
