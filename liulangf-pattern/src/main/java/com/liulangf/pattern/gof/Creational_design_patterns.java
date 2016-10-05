package com.liulangf.pattern.gof;

/**
 * <p>
 * Creational design patterns is all about class instantiation.
 * <p> 
 * Creational patterns can be further divided into class-creation patterns and object-creational patterns. 
 * While class-creation patterns use inheritance effectively in the instantiation process, object-creation 
 * patterns use delegation effectively to get the job done.
 * 
 * @author YuQing Liu
 *
 */
public interface Creational_design_patterns {
	
	/**
	 * Class inheritance.
	 */
	void class_based_creation_patterns();
	
	/**
	 * Using delegation.
	 */
	void object_based_creation_patterns();
	
	//-----------Creational Patterns-----------------------------------------
	void abstract_factory();
	
}
