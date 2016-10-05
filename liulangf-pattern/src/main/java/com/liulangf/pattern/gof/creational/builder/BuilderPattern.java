package com.liulangf.pattern.gof.creational.builder;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * The Builder pattern can be used to ease the construction of a complex object from simple objects.
 * The Builder pattern also separates the construction of a complex object from its representation so
 * that the same construction process can be used to create another composition of objects.
 * 
 * Related patterns include Abstract Factory and Composite.
 * 
 * The builder pattern moves the construction logic for an object outside the class to instantiate.
 *  
 *
 * @author Quqing Liu
 */
public class BuilderPattern {

	/**
	 * A builder also accommodates step-by-step construction, which occurs when you create an object 
	 * by parsing text and may occur when you gather an object's parameters from a user interface.
	 * 
	 * @throws Exception
	 */
	void builder_and_parser() throws Exception {
		Builder builder = new Builder() {
			public Reservation build() {
				//Construction login begins here.
				return null; 
			}
		};
		new Parser(builder).parse(new FileInputStream(""));
		Reservation reservation = builder.build();
		reservation.toString();
	}
	
}

class Reservation {}
interface Builder {
	Reservation build();
}
class Parser {
	public Parser(Builder builder) {}
	public void parse(InputStream input) {
		//do something to create the Reservation
	}
}