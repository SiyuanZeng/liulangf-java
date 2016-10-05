package com.liulangf.pattern.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * http://en.wikipedia.org/wiki/Function_object#In_Java
 * 
 * Java has no first-class functions, so function objects are usually expressed by an interface 
 * with a single method (most commonly the Callable interface), 
 * typically with the implementation being an anonymous inner class.
 * 
 * @author Quqing Liu
 */
public class FunctionObject2 {
	
	/**
     * For an example from Java's standard library, java.util.Collections.sort() takes a List and a 
     * functor whose role is to compare objects in the List. But because Java does not have first-class functions, 
     * the function is part of the Comparator interface. This could be used as follows.
	 */
	public void helloFunctionObject() {
		List<String> list = Arrays.asList("10", "1", "20", "11", "21", "12");
		 
		Comparator<String> numStringComparator = new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
		    }
		};
		 
		Collections.sort(list, numStringComparator);
	}

}
