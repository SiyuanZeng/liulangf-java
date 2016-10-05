package com.liulangf.java8.nashorn;


/**
 * Nashorn’s architecture consists of three main phases. 
 * 
 * First is the parser that creates an abstract syntax tree (AST) from the source code. 
 * The AST is then kept as internal representation (IR) throughout the different phases 
 * of the compiler. The compiler is responsible for, for example, optimizing the AST 
 * and assigning types to all expressions. In the last two phases it generates bytecode 
 * and installs it in the JVM.
 *
 * The runtime’s main responsibilities are dynamic linking and handling of dynamic types. 
 * In many cases it has to trigger recompilation of certain functions, in which case the 
 * function is recompiled from the JavaScript source code.
 * 
 */
public class NashornArchitectureTest {


}
