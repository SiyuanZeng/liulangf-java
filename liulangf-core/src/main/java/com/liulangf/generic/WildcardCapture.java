/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When a generic method is invoked, the type parameter may be chosen to match the unknown type represented by a wildcard. 
 * This is called wildcard capture.
 * 
 * Wildcard capture: 
 * Allows the compiler to infer the unknown type of a wildcard as a type argument to a generic method.
 * 
 * @author Quqing Liu
 */
public class WildcardCapture {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(WildcardCapture.class);
	
	/**
	 * The wildcard signature is slightly shorter and clearer.
	 * 
	 * @param list
	 */
	public static void reverse(List<?> list) {
		List<Object> tmp = new ArrayList<Object>(list);
		for (int i = 0; i < list.size(); i++) {
			// compile-time error
			//list.set(i, tmp.get(list.size() - i - 1)); 
			//because we are trying to write from a list of objects into a list of unknown type. 
			//Replacing List<Object> with List<?> won't fix the problem,
			//because now we have two lists with (possibly different) unknown element types.
		}
		
		//Here we say that the type variable T has captured the wildcard. 
		//This is a generally useful technique when dealing with wildcards, and it is worth knowing.
		reverse2(list);
	}
	
	/**
	 * Generic method:
	 * The second signature, it is easy to implement the method:
	 * @param <T>
	 * @param list
	 */
	private static <T> void reverse2(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}
	
	/**
	 * Another reason to know about wildcard capture is that it can show up in error messages, 
	 * even if you don't use the above technique. 
	 * In general, each occurrence of a wildcard is taken to stand for some unknown type. 
	 * If the compiler prints an error message containing this type, it is referred to as capture of ?.
	 */
	public void wildcarcInErrorMessage() {
	}
	
	
	//---------Demos from <<thinking in java>>----
	class Holder<T> {
		private T value;
		public Holder() {}
		public Holder(T val) {
			this.value = val;
		}
		public T get() {
			return value;
		}
		public void set(T value) {
			this.value = value;
		}
	}
	
	/**
	 * The type parameters in f1( ) are all exact, without wildcards or bounds. 
	 * In f2( ), the Holder parameter is an unbounded wildcard, so it would seem to be effectively unknown. 
	 * However, within f2( ), f1( ) is called and f1( ) requires a known parameter. 
	 * What’s happening is that the parameter type is captured in the process of calling f2( ), 
	 * so it can be used in the call to f1( ).
	 * 
	 * You might wonder if this technique could be used for writing, but that would require you to 
	 * pass a specific type along with the Holder<?>. Capture conversion only works in situations where, 
	 * within the method, you need to work with the exact type. Notice that you can’t return T from f2( ), 
	 * because T is unknown for f2( ). Capture conversion is interesting, but quite limited.
	 *
	 */
	static class CaptureConversion {
		static <T> void f1(Holder<T> holder) {
			T t = holder.get();
			LOGGER.info("{}", t.getClass().getName());
		}
		static void f2(Holder<?> holder) {
			//Call with captured type. Because the compile will infer the type : capture of ?
			f1(holder);
		}
	}
	
	public static void main(String...args) {
		WildcardCapture capture = new WildcardCapture();
		Holder raw = capture.new Holder<Integer>();
		CaptureConversion.f1(raw);//Produces warnings
		CaptureConversion.f2(raw);//No warnings
		
		Holder rawBasic = capture.new Holder();
		rawBasic.set(new Object());
		CaptureConversion.f2(rawBasic);//No warnings
		
		Holder<?> wildcarded = capture.new Holder<Double>(2.9D);
		CaptureConversion.f2(wildcarded);//Infered the type
		CaptureConversion.f1(wildcarded);//Infered the type
	}

}
