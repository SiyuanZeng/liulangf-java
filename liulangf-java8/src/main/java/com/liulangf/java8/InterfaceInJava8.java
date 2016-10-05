package com.liulangf.java8;

public interface InterfaceInJava8 {

	/**
	 * static method in interface
	 * @return
	 */
	public static String getName() {
		return "";
	}
	
	/**
	 * default methods.
	 * 
	 * @return
	 */
	default String getAddress() {
		return "";
	}
	
	default int getAge() {
		return 8;
	}
	
	/**
	 * default method.
	 * 1. Help to extend existing APIs. eg. Collectoin APIs
	 * 2. Minimize rewrite of existing API implementation.
	 */
	void virtual_extension_method();
}
