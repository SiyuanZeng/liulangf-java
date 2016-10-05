package com.liulangf.pattern.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * There are 4 different initialization techniques in the Java language:
 * <ul>
 *   <li>1. In an static initializer block, which executes when the class is loaded.</li>
 *   <li>2. In the main() method.</li>
 *   <li>3. In an initializer block, which executes just before the constructor.</li>
 *   <li>4. In the main() method.</li>
 * </ul>
 * 
 * @see CapturingIdiomaticPatterns
 * @author LiuYuqing
 */
public class InitializerInJava {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(InitializerInJava.class);
	public InitializerInJava() {
		LOGGER.info("== 4.In constructor ==");
	}
	
	static {
		LOGGER.info("== 1.In static initializer ==");
	}

	/**
	 * Instance initializers allow you to execute construction code for an anonymous inner class.
	 * new Object() {{}}.
	 * In fact, it's the only real initialization mechanism, because it is impossible to write a 
	 * constructor for an anonymous inner class - the constructor must have the same name as the class,
	 * but the class for an anonymous inner class has no name. 
	 */
	{
		LOGGER.info("== 3.In instance initializer ==");
	}
	
	public static void main(String...args) {
		LOGGER.info("== 2.In main() method ==");
		new InitializerInJava();
	}
}
