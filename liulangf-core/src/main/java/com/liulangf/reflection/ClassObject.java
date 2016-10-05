package com.liulangf.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * The Java Language Specification, Third Edition (15.8.2 Class Literals)
 * 
 * @author YuQing Liu
 *
 */
public class ClassObject {
	
	
	void reflection(String className) throws ClassNotFoundException {
		Class<?> c = Class.forName(className);
		Package p = c.getPackage();
	}
	
	void newInstance(String className) 
			throws ClassNotFoundException, 
			InstantiationException, 
			IllegalAccessException, 
			SecurityException, 
			NoSuchMethodException, 
			IllegalArgumentException, 
			InvocationTargetException {
		//1. default constructor
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		
		Class<Simple> cs = Simple.class;
		//2.
		Class<?>[] pTypes = new Class[] {int.class, String.class};
		Constructor<Simple> ctor = cs.getConstructor(pTypes);
		Simple simple = ctor.newInstance(new Object[] {23, ""});
	}
	

	class Simple {
		public Simple(int a, String b) {}
	}
}
