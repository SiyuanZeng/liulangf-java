package com.liulangf.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 *  java.lang.Class;
 *  java.lang.reflect.*;
 * 
 *  java.lang.reflect.AccessibleObject;
 *  java.lang.reflect.AnnotatedElement;
 *  java.lang.reflect.Array;
 *  java.lang.reflect.Constructor;
 *  java.lang.reflect.Field;
 *  java.lang.reflect.GenericArrayType;
 *  java.lang.reflect.GenericDeclaration;
 *  java.lang.reflect.GenericSignatureFormatError;
 *  java.lang.reflect.InvocationHandler;
 *  java.lang.reflect.InvocationTargetException;
 *  java.lang.reflect.Member;
 *  java.lang.reflect.Modifier;
 *  java.lang.reflect.Method; 
 *  java.lang.reflect.MalformedParameterizedTypeException;
 *  java.lang.reflect.ParameterizedType;
 *  java.lang.reflect.Proxy;
 *  java.lang.reflect.ReflectPermission;
 *  java.lang.reflect.Type;
 *  java.lang.reflect.TypeVariable;
 *  java.lang.reflect.WildcardType;
 * 
 * @author YuQing Liu
 *
 */
public class ReflectionCoreAPI {
	
	/**
	 * java.lang.Class;
	 * java.lang.reflect.Constructor;
	 * java.lang.reflect.Field;
	 * java.lang.reflect.Method;
	 */
	void introspection() {}
	
	/**
	 * Three issues that have thus far impeded the broad use of reflection:
	 * <ul>
	 * <li>Security</li>
	 * <li>Code complexity</li>
	 * <li>Runtime performance</li>
	 * </ul>
	 */
	void issus() {}
	
	/**
	 * java.lang.reflect.Method;
	 * Dynamic invocation is a feature that enables a program to call a method on an object 
	 * at runtime without specifying which method at compile time.
	 * 
	 * In Java, each method is identified by both its signature and its declaring class.
	 */
	void dynamic_method_invocation() 
			throws IllegalArgumentException, 
			IllegalAccessException, 
			InvocationTargetException, 
			SecurityException, 
			NoSuchMethodException {
		Method method = getClass().getMethod("helloworld", new Class<?>[] {});
		method.invoke(this, new Object[] {});
	}
	
	/**
	 * Java arrays are objects, but their classes are created by JVM at runtime.
	 */
	void array_type() {}

}
