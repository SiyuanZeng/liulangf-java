package com.liulangf.dsl.martin;

/**
 * http://www.martinfowler.com/bliki/EvansClassification.html
 * It is about Eric Evans's classification on Domain object.
 * 
 * <<Domain-Driven Design: Tackling Complexity in the Heart of Software>> 
 * -- by Eric Evans
 * 
 * http://domaindrivendesign.org/
 * 
 * In his excellent book Domain Driven Design, Eric Evans creates a classification of 
 * the different kinds of domain objects that you're likely to run into.
 * 
 * <ul>
 *   <li>Entity</li>
 *   <li>Value Object</li>
 *   <li>Service</li>
 * </ul>
 *
 * @author Quqing Liu
 */
public interface EvansClassification {
	
	/**
	 *  Objects that have a distinct identity that runs through time and different representations. 
	 *  You also hear these called "reference objects"
	 */
	void entity();

	/**
	 * Objects that matter only has the combination of their attributes. 
	 * Two value objects with the same values for all their attributes are considered equal.
	 */
	void value_object();
	
	/**
	 * A standalone operation within the context of your domain. 
	 * A Service Object collects one or more services into an object. 
	 * Typically you will have only one instance of each service object type within your execution context.
	 */
	void service();
}
