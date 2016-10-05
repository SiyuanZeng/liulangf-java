package com.liulangf.spi;


/**
 * http://www.ibm.com/developerworks/cn/java/j-lo-classloader/index.html
 * @author liulangf
 *
 */
public class ClassLoading {

	
	public static void main(String... args) {
		ClassLoader loader = ClassLoading.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString() + "==>" + loader.getClass().getCanonicalName());
			loader = loader.getParent();
		}
	}
	
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back to system class loader...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = ClassLoading.class.getClassLoader();
		}
		return cl;
	}
}
