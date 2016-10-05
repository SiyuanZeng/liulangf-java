package com.liulangf.ioc.jsr.jsr330;

/**
 * @author YuQing Liu
 *
 */
public interface DependencyInjectionForJava {
	
	/**
	 * javax.inject.Inject;       - Identifies injectable constructors, methods, and fields.
	 * javax.inject.Qualifier;    - Identifies qualifier annotations.
	 * javax.inject.Named;        - Identifies scope annotations.
	 * javax.inject.Scope;        - String-based qualifier.
	 * javax.inject.Singleton;    - Identifies a type that the injector only instantiates once.
	 * javax.inject.Provider<T>;  - Provides instances of a type T. For any type T that can be injected, you can also inject Provider.
	 */
	void jsr330();
	
	/**
	 * The @Inject annotation can be used with three class member types to indicate where 
	 * you’d like a dependency to be injected.
	 * <ul>
	 *   <li>Constructors</li>
	 *   <li>Methods---setter method</li>
	 *   <li>Fields</li>
	 * </ul>
	 * 
	 * It has become a default best practice to use constructor injection for setting 
	 * mandatory dependencies for a class and to use setter injection for nonmandatory 
	 * dependencies, such as fields that already have sensible defaults.
	 * 
	 */
	void inject_annatation();

}
