/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.tdd.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * The core concepts of jMock API are the mockery, mock objects, and expectations.
 * A mockery represents the context of the object under test, its neighboring objects; 
 * mock objects stand in for the real neighbors of the object under test while the test runs; 
 * and expectations describe how the object under test should invoke its neighbors during the test.
 *
 * @author Quqing Liu
 */
@RunWith(JMock.class)
public class StandUpTest {
	
	/**
	 * For the object under test, a Mockery represents its context—the neighboring objects it will communicate with. 
	 * The test will tell the mockery to create mock objects, to set expectations on the mock objects, and to check 
	 * at the end of the test that those expectations have been met. By convention, the mockery is stored in 
	 * an instance variable named context.
	 */
	final Mockery context = new JUnit4Mockery();
	
	/**
	 * The @RunWith(JMock.class) annotation tells JUnit to use the jMock test runner, 
	 * which automatically calls the mockery at the end of the test to check that all 
	 * mock objects have been invoked as expected.
	 */
	void jmock_runner() {}
	
	
	@Test public void 
	underTest() {
		//create mock object
		final Turple turple = context.mock(Turple.class, "Turple.class");
		
		/**
		 * We’re passing to the checking() method an anonymous subclass of Expectations (first set of braces). 
		 * Within that subclass, we have an instance initialization block (second set of braces) that 
		 * Java will call after the constructor. Within the initialization block, we can reference the enclosing
		 * Expectations object, so oneOf() is actually an instance method.
		 * 
		 * The purpose of this baroque structure is to provide a scope for building up expectations. 
		 * All the code in the expectation block is defined within an anonymous instance of Expectations, 
		 * which collects the expectation components that the code generates. The scoping to an instance 
		 * allows us to make this collection implicit, which requires less code.
		 * 
		 * Expectations is an example of the Builder pattern
		 */
		context.checking(new Expectations() {{
			oneOf(turple).turn(15);
			
		}});
		
	}
	
	/**
	 * Expectations have the following structure: 
	 *   invocation-count(mock-object).method(argument-constraints);
	 *   inSequence(sequence-name);
	 *   when(state-machine.is(state-name));
	 *   will(action);
	 *   then(state-machine.is(new-state-name));
	 *   
	 * The invocation-count and mock-object are required, all the other clauses are optional. 
	 * You can give an expectation any number of inSequence, when, will, and then clauses.
	 */
	void syntax_of_jmock() {
	}

}

interface Turple {
	int turn(int arg);
}
