package com.liulangf.clojure;

import java.io.IOException;

import clojure.lang.RT;
import clojure.lang.Var;

/**
 * 
 *
 * @author liulangf
 *
 */
public class ClojureInJave {
	
	
	public void script() throws IOException {
		
		RT.loadResourceScript("clojure/file/from/classpath/clojure_script.clj");
		Var aClojureFunction = RT.var("a-clojure-ns", "a-clojure-function");
		aClojureFunction.invoke("arguments");
	}
	
	

}
