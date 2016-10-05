package com.liulangf.reflection;

/**
 * @author YuQing Liu
 *
 */
public class ClassObjectFactory {
	
	/**
	 * private Class() {}
     * Only the Java Virtual Machine creates Class objects.
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unused")
	Class<?> getClassObject() throws ClassNotFoundException {
		Class<?> c1 = "".getClass();
		Class<? extends String> c2 = "".getClass();
		Class<?> c3 = c2.getSuperclass();
		
		Class<?> c4 = Class.forName("java.lang.String");
		Class<?> c5 = Class.forName("java.util.LinkedList$Entry");
		Class<?> c6 = Class.forName("I");
		Class<?> c7 = Class.forName("I[");
		
		Class<?> c8 = String.class;
		Class<?> c9 = int.class;
		Class<?> c10 = int[].class;
		
		Class<?> c11 = Boolean.TYPE;
		//........
		Class<?> c12 = Void.TYPE;
		
		return null;
	}

}
