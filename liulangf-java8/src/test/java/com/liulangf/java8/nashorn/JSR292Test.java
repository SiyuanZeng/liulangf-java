package com.liulangf.java8.nashorn;

import org.junit.Test;

/**
 * JSR292: Supporting Dynamically Typed Languages on the java Platform
 *     invokedynamic bytecode allows programmers to call a method just by name. Method resolution
 *     is implemented through custom, user defined lookup methods.
 * 
 * JSR292:
 *   1. invokedynamic bytecode instruction(It's not about invocation but about runtime linkage)
 *   2. MethodHandles 
 *   
 *   Nashorn JavaScript engine already uses "dynalink" library for linking properties, 
 *   indexed access, calls on it's (script) objects as well as "foreign"/"host" Java objects (POJOs). 
 *   With JEP-276, dynalink is exposed as a public (JDK specific) API in the java9 module named "jdk.dynalink".
 *   
 *   Dynalink provides a high-level linking meta object protocol library, allowing the creation of languages 
 *   on the JVM can interoperate with POJOs and each other.
 *   
 *   Dynalink claims it can “pass objects from Ruby to Python to JavaScript to Java and back” in one JVM with minimal effort on the developers.
 *   http://medianetwork.oracle.com/video/player/1113272541001
 *   
 *   At runtime, an invokedynamic call site is bound to a method handle by way of a bootstrap method. 
 *   This method is executed the first time the JVM encounters this call site during execution.
 *   
 *   The invokedynamic instruction is followed by an operand that serves as an index into the classfile's constant pool.
 *   The value in the constant pool at this index is a CONSTANT_InvokeDynamic structure. 
 *   This structure includes an index into the classfile's BootstrapMethods attribute, which ultimately identifies the bootstrap method.
 */
public class JSR292Test {

	/**
	 * http://www.javaworld.com/article/2860079/scripting-jvm-languages/invokedynamic-101.html?page=2
	 */
	@Test
	public void test() {
	}
	
	/**
	 * In java 7 the invokedynamic bytecode instruction was introduced to tackle the problem with
	 * dynamic linking for dynamic language.
	 * 
	 * It gives full control of linkage to the developers to handle at runtime and does so in a way
	 * that does not require the calling method to be recompiled and replaced.
	 * 
	 * Every invokedynamic instruction specifies a bootstrap method that returns a java.lang.invoke.CallSite
	 * instance. The CallSite instance contains a reference to the method that should be invoked in the form
	 * of a java.lang.invoke.MethodHandle instance.
	 * 
	 * 
	 * 
	 */
	@Test
	public void invokeDynamic() {
	}
	
	/**
	 * http://www.gutenberg.us/articles/jsr_292
	 * 
	 * Dynamic invocation is built on the fact that, even if Java is a strongly static language at the language level, 
	 * the type information is much less prevalent at the bytecode level.
	 * 
	 * JSR 292 proposes to:
	 *   provide a mechanism whereby an existing class can be loaded and modified, producing a new class with those 
	 *   modifications but sharing the rest of its structure and data, thus not filling the Permanent Generation space,
	 *   provide the new invokedynamic bytecode which allows the JVM to optimize these kind of calls.
	 * 
	 * 
	 */
	public void jsr292() {
	}
	
	/**
	 * http://www.infoq.com/news/2008/05/jsr_292_edr
	 * 
	 * Why add another invoke bytecode? The answer is that call sites (instances of invoke bytecodes) are useful, 
	 * and yet the existing formulas for invocation are tied so closely to the Java language that the natural capabilities 
	 * of the JVM are not fully available to languages that would benefit from them. The key restrictions are:
	 * 
	 *   1. the receiver type must conform to the resolved type of the call site
	 *   2. there is no generic way to create adapters around call targets (a corollary of the previous point)
	 *   3. the call site must link, which means the resolved method always pre-exists
	 *   4. the symbolic call name is the name of an actual method (a corollary of the previous point)
	 *   5. argument matching is exact with no implicit coercions (another corollary)
	 *   6. linkage decisions cannot be reversed (although optimization decisions change, invisibly)
	 *   
	 * Our solution to these requirements is in three steps. 
	 *   First, we factor out method handles as a simple and generic way of managing methods (arbitrary JVM methods) 
	 *       as units of behavior, which are (as methods should be) directly callable. 
	 *   Second, we define an invokedynamic instruction with one machine word of linkage state, a handle to the 
	 *       call site’s target method. 
	 *   Third, we define a set of core Java APIs for managing linkage state and creating the target method handles 
	 *   for call sites, taking care they these APIs can present the right optimization opportunities to JVMs that wish to exploit them.
	 * 
	 */
	public void jsr292edr() {
	}
	
	/**
	 * http://docs.oracle.com/javase/7/docs/api/java/lang/invoke/package-summary.html
	 * http://docs.oracle.com/javase/7/docs/technotes/guides/vm/multiple-language-support.html
	 * 
	 * The Java SE 7 platform enables non-Java languages to exploit the infrastructure and potential performance optimizations of the JVM. 
	 * The key mechanism is the invokedynamic instruction, which simplifies the implementation of compilers and runtime systems for 
	 * dynamically typed languages on the JVM.
	 * 
	 * The Challenge of Compiling Dynamically Typed Languages
	 *         The challenge of compiling dynamically typed languages is how to implement a runtime system that can choose the most appropriate 
	 *             implementation of a method or function — after the program has been compiled.
	 *         Java SE 7 introduces the invokedynamic instruction that enables the runtime system to customize the linkage between a call site and a 
	 *             method implementation. 
	 *     
	 *      
	 *  
	 */
	public void jsr292api() {
	}

}
