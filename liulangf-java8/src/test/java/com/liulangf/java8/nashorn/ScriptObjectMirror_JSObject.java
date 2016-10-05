package com.liulangf.java8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * https://wiki.openjdk.java.net/display/Nashorn/Nashorn+jsr223+engine+notes
 */
public class ScriptObjectMirror_JSObject {

	/**
	 * ScriptObjectMirror and JSObject
	 * 
	 * Nashorn represents script objects created by script as instances of jdk.nashorn.internal.runtime.ScriptObject or a subclass of it. 
	 * For example, nashorn global object is an instance of jdk.nashorn.internal.objects.Global class. 
	 * 
	 * These are implementation classes and therefore can not be accessed by user code. 
	 * Under security manager, attempt to access this class or any subclass will result in SecurityException being thrown. 
	 * 
	 * jdk.nashorn.api.scripting.ScriptObjectMirror class is the API entry point for nashorn "ECMAScript script objects". 
	 * Whenever "eval" results in a script object value (i.e., not a Java object or any "foreign" object), the script object is 
	 * returned as ScriptObjectMirror.
	 * 
	 *     ScriptObjectMirror sobj = (ScriptObjectMirror)engine.eval("({ foo: 23 }");
	 *     System.out.println(sobj.get("foo")); // prints 23
	 * 
	 * 
	 * ScriptObjectMirror class implements jdk.nashorn.api.scripting.JSObject interface and javax.script.Bindings interface. 
	 * JSObject exposed methods like getMember, getSlot, setMember, setSlot, call etc. to access properties and call functions.
	 * @throws ScriptException 
	 * @throws FileNotFoundException 
	 * 
	 */
	public void script_object() throws FileNotFoundException, ScriptException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		ScriptObjectMirror sobj = (ScriptObjectMirror)engine.eval("({ foo: 23 }");
		System.out.println(sobj.get("foo")); // prints 23
	}
	
	
	/**
	 * Since ScriptObjectMirror is final, you cannot extend from this class. 
	 * ScriptObjectMirror is used by the Nashorn Engine to pass javascript objects to the Java side, 
	 * not the other way around.
	 * 
	 * http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
	 * ScriptObjectMirror
	 */
	public void bridge() {
		
	}
	
}
