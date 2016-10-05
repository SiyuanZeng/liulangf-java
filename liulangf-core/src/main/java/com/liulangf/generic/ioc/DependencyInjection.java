package com.liulangf.ioc;

/**
 * Annotation-based development.
 * Allows developers to embed metadata directly into java source code.
 * 
 * The java6 specification includes some built-in annotation types and annotation-processing APIS:
 *   JSR 181 - Web services metadata for the java Platform
 *   JSR-220 - EJB annotations.
 *   JSR 250 - Common Annotations for the java Platform
 *   JSR 269 - Pluggable Annotation Processing API
 *   JSR-330 - Dependency Injection for Java
 *   
 *   Spring supports JSR250, and using
 *   <bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
 *   or <context:annotation-config/>
 *   
 *   JSR330
 *   @Inject – 		Identifies injectable constructors, methods, and fields.
 *   @Qualifier - 	Identifies qualifier annotations
 *   @Scope - 		Identifies scope annotations
 *   @Named - 		String-based qualifier
 *   @Singleton - 	Identifies a type that the injector only instantiates once
 *   
 *   Some rules:
 *     1. Behaviorally focused
 *     2. Modular
 *     3. Testable
 *     
 *  Dependency injector, such as SpringFramework and guice.
 *  Metadata and injector configuration:
 *    1. Using an XML configuration file
 *    2. Invoking into a programmatic API
 *    3. Using an injection-oriented DSL
 *    4. By inference; that is, implicitly from the structure of classes
 *    5. By inference from annotated source code. 
 * 
 * @author YuQing Liu
 */
public class DependencyInjection {

	/**
     * Seeing objects as services.
     * The relationship of objects is called a dependency. The composite system of dependencies is
     * commonly called an object graph.
     * 
     * A Service Locator pattern is a kind of Factory. It is a third-party object responsible for
     * producing a fully constructed object graph.
     * 
     * Dependency injection offers an innovative alternative via the Hollywood Principle: 
     * Don't call us; we'll call you. Meaning that a component need know nothing about its
     * dependencies nor explicitly ask for them. 
	 */
	public DependencyInjection() {
	}
	

}
