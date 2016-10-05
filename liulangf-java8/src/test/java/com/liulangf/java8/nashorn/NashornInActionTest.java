package com.liulangf.java8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import org.junit.Test;

/**
 * Nashorn is a JavaScript engine that executes JavaScript on top of JVM. It relies heavily on the new 
 * bytecode instruction invokedynamic.
 *
 * Under the hood, Nashorn uses the invokedynamic JVM instruction to implement all of its invocations. 
 * That is a major component of the comparative improvement of performance and memory usage regarding Mozilla Rhino. 
 * Since JavaScript does not have a ‘native’ bytecode format, JavaScript source code is first parsed to construct 
 * an immediate representation (AST/IR). The AST/IR is then lowered to something closer to JVM bytecode by transformation 
 * of controls, reduction of expressions to primitive operations, and simplification of calls, to be efficiently 
 * translated to JVM instructions, and securely loaded into the JVM. Generated code and call history are cached by 
 * the linker, to make lookup and invocation faster on successive relinks - JavaScript being a dynamic language, 
 * the actual code that needs to be ran by the JVM for a function being invoked at a given point in the code may 
 * change over time, and need to be recompiled and relinked. Nashorn takes care of all that under the hood using high 
 * quality third party helper libraries.
 * 
 * It does so very efficiently - it currently performs about 2x till 10x better than Mozilla Rhino on individual 
 * JavaScript engine benchmarks from the Octane benchmark suite.
 * 
 *
 */
public class NashornInActionTest {

	@Test
	public void test() {
	}
	
	/**
	 * optimistic[乐观的] type guessing.
	 * 
	 */
	public void optimistic_type_guessing() {
	}
	
	@Test
	public void compileonlyTest() throws ScriptException, FileNotFoundException {
		String[] args = new String[] {
				"--compile-only",
				"--dump-debug-dir=c:/temp/nashorn"
		};
		ScriptEngine nashorn = new NashornScriptEngineFactory().getScriptEngine(new String[] { "-doe", "--compile-only" });
		nashorn.setBindings(new SimpleBindings(), ScriptContext.GLOBAL_SCOPE);
		//Reader reader = new FileReader("underscore.js");
		Object u = nashorn.eval("print('a')");
	}

}
