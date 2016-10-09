package com.liulangf.pattern.common;

/**
 * <<Effective Java2>> Item 21
 * Use function objects to represent strategies.
 * 
 * Some languages support function pointers,delegates,lambda expressions,or
 * similar facilities that allow programs to store and transmit the ability to 
 * invoke a particular function.
 * 
 * @author Quqing Liu
 */
public class FunctionObject {
	
	public void invoke(String s1, String s2, Command command) {
		command.execute(s1, s2);
	}
}

interface Command {
	void execute(String s1, String s2);
}
