package com.liulangf.java8.nashorn;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;


/**
 * https://www.youtube.com/watch?v=UIv86fUSORM
 * 
 * 1. A CallSite is an object that holds a target MethodHandle.
 * 2. A method handle is like a function pointer.
 * 3. BootStrap method returns a call site bound to a method handle.
 * 4. A call site is a reification[具体化] of the INVOKEDYNAMIC instruction that can be manipulated form Java code. 
 * 5. Some call sites are mutable, you can set their method handle repeatedly.
 * 
 *
 */
public class CallSiteTest {

	//private static final DynamicLinker linder = new DynamicLinkerFactory().createLinker();
	
	/**
	 * Bootstrap method in some class:
	 * 
	 * @param lookup
	 * @param name
	 * @param type
	 * @return
	 */
	public static CallSite bootstrap(Lookup lookup, String name, MethodType type) {
		return null;
	}

}
