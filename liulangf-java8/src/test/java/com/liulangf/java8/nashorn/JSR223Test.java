package com.liulangf.java8.nashorn;

import java.io.File;
import java.io.FileNotFoundException;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.Test;


/**
 * JSR223 defines certain contracts between the JVM and a scripting language.
 * JSR223 API: Interactions between a java platform application and an engine.
 * 
 * JSR223 
 *     javax.script.*;
 *     
 *     javax.script.ScriptEngine
 *         -Interprets and runs("evaluates") your scripts
 *     
 *     javax.script.Bindings
 *         -Variable Binding between Scripts and App.
 *     
 *     javax.script.ScriptContext
 *         -Context for evaluating Scripts
 *         -Bindings(Scopes)
 * 
 * Variable Bindings
 *   -Global Scope (Shared Bindings)
 *   -Engine Scope
 *   -Runtime Scope (Non-shared Bindings)
 *     
 * 
 * The starting point of the scripting API is the ScriptEngineManager class. 
 * A ScriptEngineManager object can discover script engines through the jar file service discovery mechanism. 
 * It can also instantiate ScriptEngine objects that interpret scripts written in a specific scripting language. 
 * The simplest way to use the scripting API is as follows:
 *     1. Create a ScriptEngineManager object.
 *     2. Get a ScriptEngine object from the manager.
 *     3. Evaluate script using the ScriptEngine's eval methods.
 *     
 * JSR223 defines six classes and six interfaces:
 *     1. The scripting engine for a language;
 *     2. The context in which a script is running.
 */
public class JSR223Test {

	@Test
	public void helloWorld() throws ScriptException, FileNotFoundException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine nashorn = manager.getEngineByName("nashorn");
		nashorn.eval("print('Hello World')");
		//nashorn.eval(new FileReader("js/hello.js"));
		
		nashorn.put("file", new File("hello.js"));
		nashorn.eval("print(file.getAbsolutePath())");
		
		nashorn.eval("function hello(name) { print('Hello, ' + name); }");
		
		Invocable inv = (Invocable) nashorn;
		inv.invokeFunction("hello", "Nashorn!");
	}
	
	

	/**
	 * A single scope is an instance of javax.script.Bindings.  This interface is derived from java.util.Map<String, Object>. 
	 * A scope a set of name-value pairs where name is any non-empty, non-null String.
	 *  
	 * Multiple scopes are supported by javax.script.ScriptContext interface. 
	 * A script context supports one or more scopes with associated Bindings for each scope.
	 *  
	 * By default, every script engine has a default script context. 
	 * The default script context has at least one scope called "ENGINE_SCOPE".
	 *  
	 * Various scopes supported by a script context are available through getScopes method.
	 * @throws ScriptException 
	 */
	@Test
	public void scopeTest() throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine nashorn = manager.getEngineByName("nashorn");
		nashorn.put("x", "hello");
		nashorn.eval("print(x);");//hello
		
		ScriptContext nc = new SimpleScriptContext();
		Bindings engineScope = nc.getBindings(ScriptContext.ENGINE_SCOPE);
		engineScope.put("x", "world");
		
		nashorn.eval("print(x);", nc);//world
	}
	
}
