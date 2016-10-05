package com.liulangf.ioc.jsr;

/**
 * 
 * JSR 250: Common annotations for Java Platform.
 * JSR 330: Standardized Dependency Injection in Java (Java SE).
 * JSR 299: Contexts and Dependency Injection for the Java EE platform.
 * 
 * @author YuQing Liu
 *
 */
public interface JSRs {
	
	/**
	 * 
	 */
	void jsr250();
	
	/**
	 * javax.inject.Inject;       - Identifies injectable constructors, methods, and fields.
	 * javax.inject.Qualifier;    - Identifies qualifier annotations.
	 * javax.inject.Named;        - Identifies scope annotations.
	 * javax.inject.Scope;        - String-based qualifier.
	 * javax.inject.Singleton;    - Identifies a type that the injector only instantiates once.
	 * javax.inject.Provider<T>;  - Provides instances of a type T. For any type T that can be injected, you can also inject Provider.
	 */
	void jsr330();
	
	void jsr299();

	/**
	 * Although JSR-330 annotations allow you to inject dependencies for a method, 
	 * it’s typically only done for constructors or setters.
	 */
	void jsr330_Inject_convention();
}
