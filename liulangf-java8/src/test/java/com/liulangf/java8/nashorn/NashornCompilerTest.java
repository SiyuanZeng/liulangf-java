package com.liulangf.java8.nashorn;



/**
 * https://dzone.com/articles/how-java-8-handles-javascript
 * 
 * Unlike Java and Scala whose compilers are persistent (i.e. generate .class / jar files to disk), 
 * Nashorn compiles everything in memory and passes the bytecode to the JVM directly.
 * 
 * 
 * invokeDynamic:
 * the invokeDynamic instruction was added in Java 7 to allow folks writing their own dynamic languages to decide at runtime how to link code.
 * 
 */
public class NashornCompilerTest {
	
	/**
	 * For static languages like Java and Scala, the compiler decides at compile time which method would be invoked 
	 * (with some help from the JVM runtime for polymorphism). 
	 * 
	 * The runtime linking is done via standard ClassLoaders to lookup the class. Even things like method overload 
	 * resolution are done at compile time.
	 */
	public void compile_time() {
	}

	/**
	 * InvokeDynamic enables deferring[推迟] of linkage back to the writers of the language at run-time, so they can guide the JVM as to which method they would like to call, based on their own language semantics. This is a win-win situation. The JVM gets an actual method to link to, optimize and execute against, and the language makers control its resolution.
	 */
	public void dynamic_link() {
	}

	/**
	 * invokedynamic 0 "dyn:getProp|getElem|getMethod:prototype":(Ljava/lang/Object;)Ljava/lang/Object;
	 * 
	 * Nashorn is asking the JVM to pass it this string at runtime, and in exchange it will return a handle to a method 
	 * which accepts an Object and returns one. As long as the JVM gets a handle to such a method, it can link. 
	 * 
	 * The method responsible for returning this handle (also known as a bootstrap method) is specified in a special 
	 * section in the .class file which holds a list of available bootstrap methods. The 0 value you see is the index 
	 * within that table of the method which the JVM will invoke to get the method handle to which it will link.
	 */
	public void bootstrap_method() {
	}
}
