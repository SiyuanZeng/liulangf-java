package com.liulangf.pattern.gof.creational.factory_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.slf4j.org/manual.html
 * 
 * SLF4J does not rely on any special class loader machinery. 
 * In fact, the each SLF4J binding is hard wired at compile time to use one and only one specific logging framework. 
 * For example, the slf4j-log4j12-1.6.4.jar binding is bound at compile time to use log4j. In your code, in addition 
 * to slf4j-api-1.6.4.jar, you simply drop one and only one binding of your choice onto the appropriate class path 
 * location. Do not place more than one binding on your class path.
 * 
 * 
 * Static(early) binding in java:
 *   <ul>
 *     <li>static method</li>
 *     <li>constructor</li>
 *     <li>private method</li>
 *     <li>super.superMethod()</li>
 *   </ul>
 * 
 * @author liulangf
 * 
 * @see org.slf4j.LoggerFactory#bind()
 *
 */
public class SLF4JBindingPattern {
	
	private static final transient Logger Logger = LoggerFactory.getLogger(SLF4JBindingPattern.class);

}
