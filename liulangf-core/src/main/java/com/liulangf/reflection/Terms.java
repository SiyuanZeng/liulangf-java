package com.liulangf.reflection;

/**
 * Uses of java reflection(A lot of tools use java reflection):
 * <ul>
 * <li>Plugins to extend functionality of an application(Ant)</li>
 * <li>Auto-completion in java editors and IDEs</li>
 * <li>Use naming conventions of methods to infer semantics(JUnit test methods)</li>
 * <li>Tie components together(Sping)</li>
 * <li>Compile-time code generation</li>
 * <li>Runtime code generation
 *      - Generate proxies
 *      - Generate servlets from a markup language(JSP)</li>
 * <li>Evaluate java expressions entered interactively by a user.</li>
 * </ul>
 * 
 * From <<Java reflection in action>>:
 * Reflection is the ability of a running program to examine itself and its software environment, 
 * and to change what it does depending on what it finds. 
 * 
 * To perform this self-examination, a program needs to have a representation of itself. 
 * This information we call metadata. In an object-oriented world, metadata is organized into objects,
 * called metaobjects. The runtime self-examination of the metaobjects is called introspection.
 * 
 * @author YuQing Liu
 *
 */
public interface Terms {
	
	/**
	 * The ability of the program to examine itself.
	 */
	void introspection();
	
	/**
	 * Reflection is infrastructure enabling a program can see and manipulate itself.
	 * It consists of metadata plus operations to manipulate the metadata.
	 * 
	 * Meta means self-referential. So metadata is data(information) about oneself.
	 * 
	 * Reflection seems natural to people who have written compilers (A parse tree is
	 * conceptually similar to metadata in reflection).
	 * 
	 * A lot of refection-based programming uses recursion.
	 */
	void reflection();

	void dynamic_binding();
	
	void dynamic_linking();
	
	void dynamic_loading();
}

