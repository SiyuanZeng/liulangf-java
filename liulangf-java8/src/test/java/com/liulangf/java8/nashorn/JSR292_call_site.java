package com.liulangf.java8.nashorn;

import org.junit.Test;

public class JSR292_call_site {

	/**
	 * http://docs.oracle.com/javase/7/docs/technotes/guides/vm/multiple-language-support.html
	 * 
	 * The invokedynamic instruction allows the language implementer to define custom linkage behavior.
	 * 
	 * Each instance of an invokedynamic instruction is called a dynamic call site. 
	 * A dynamic call site is originally in an unlinked state, which means that there is no method specified 
	 * for the call site to invoke. As previously mentioned, a dynamic call site is linked to a method by means 
	 * of a bootstrap method. 
	 * 
	 * A dynamic call site's bootstrap method is a method specified by the compiler for the dynamically-typed language 
	 * that is called once by the JVM to link the site. The object returned from the bootstrap method permanently 
	 * determines the call site's behavior.
	 * 
	 * 
	 */
	public void dynamic_call_site() {
	}

	/**
	 * The invokedynamic instruction contains a constant pool index (in the same format as for the other invoke instructions). 
	 * This constant pool index references a CONSTANT_InvokeDynamic entry. This entry specifies the bootstrap method (a CONSTANT_MethodHandle entry), 
	 * the name of the dynamically linked method, and the argument types and return type of the call to the dynamically linked method.
	 * 
	 */
	public void invokedynamic_instruction() {
	}
	
	/**
	 * Invoking a dynamically linked method with the invokedynamic instruction involves the following steps:
	 * 
	 *   1. Defining the Bootstrap Method
	 *   2. Specifying Constant Pool Entries
	 *   3. Using the invokedynamic Instruction
	 */
	public void invoking_dynamic_method() {
		
	}

}
