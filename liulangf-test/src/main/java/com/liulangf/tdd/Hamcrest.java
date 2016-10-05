/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.tdd;

/**
 * http://code.google.com/p/hamcrest/
 * http://code.google.com/p/hamcrest/wiki/Tutorial
 * 
 * Provides a library of matcher objects (also known as constraints or predicates) allowing 
 * 'match' rules to be defined declaratively, to be used in other frameworks. 
 * Typical scenarios include testing frameworks, mocking libraries and UI validation rules.
 * @author Quqing Liu
 */
public class Hamcrest {
	
	/**
	 * Hamcrest comes with a library of useful matchers. Here are some of the most important ones.
	 * 
	 * Core
	 *   anything - always matches, useful if you don't care what the object under test is
	 *   describedAs - decorator to adding custom failure description
	 *   is - decorator to improve readability - see "Sugar", below
	 *   
	 * Logical
	 *   allOf - matches if all matchers match, short circuits (like Java &&)
	 *   anyOf - matches if any matchers match, short circuits (like Java ||)
	 *   not - matches if the wrapped matcher doesn't match and vice versa
	 *   
	 * Object
	 *   equalTo - test object equality using Object.equals
	 *   hasToString - test Object.toString
	 *   instanceOf, isCompatibleType - test type
	 *   notNullValue, nullValue - test for null
	 *   sameInstance - test object identity
	 *   
	 * Beans
	 *   hasProperty - test JavaBeans properties
	 *   
	 * Collections
	 *   array - test an array's elements against an array of matchers
	 *   hasEntry, hasKey, hasValue - test a map contains an entry, key or value
	 *   hasItem, hasItems - test a collection contains elements
	 *   hasItemInArray - test an array contains an element
	 *   
	 * Number
	 *   closeTo - test floating point values are close to a given value
	 *   greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - test ordering
	 *   
	 * Text
	 *   equalToIgnoringCase - test string equality ignoring case
	 *   equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
	 *   containsString, endsWith, startsWith - test string matching
	 */
	void common_matchers() {
		
	}
}
