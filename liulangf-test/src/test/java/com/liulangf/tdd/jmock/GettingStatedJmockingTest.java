package com.liulangf.tdd.jmock;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * jMock 2 is a library for testing Java code using mock objects. 
 * Mock objects help you design and test the interactions between the objects in your programs.
 * 
 * jMock 2:
 * 1. makes it quick and easy to define mock objects, so you don't break the rhythm of programming.
 * 2. lets you define flexible constraints over object interactions, reducing the brittleness of your tests.
 * 3. acts as a "domain-specific embedded language" for specifying expectations so it is easy to read and understand the intent of tests with mock objects.
 * 4. uses real method calls to specify expectations, so code can be easily refactored in modern IDEs.
 * 5. is easy to extend.
 * 
 * Mockery
 * A Mockery represents the context, or neighbourhood, of the object(s) under test. 
 * The neighbouring objects in that context are mocked out. 
 * The test specifies the expected interactions between the object(s) under test 
 * and its neighbours and the Mockery checks those expectations while the test is running.
 * 
 * State
 * States are used to specify that invocations can occur only during some state 
 * that is initiated and/or terminated by other expected invocations. 
 * A test can define multiple state machines and an invocation can be 
 * constrained to occur during a state of one more more state machines.
 * 
 * Sequences are used to define expectations that must occur in the order in which they appear in the test code. 
 * A test can create more than one sequence and an expectation can be part of more than once sequence at a time.
 * 
 * @author LiuYuQing
 */
@RunWith(JMock.class)
public class GettingStatedJmockingTest {
	
	//A Mockery represents the context, or neighborhood, of the object(s) under test.
	private Mockery context = new Mockery();
	
	@Test
	public void testSomeAction() {
		//1. setup
		final HelloJmock hello = context.mock(HelloJmock.class, "HelloJmock.class");
		TddDemo tdd = new TddDemo(hello);
		final String msg = "hello";
		//2.specifying expectations
		context.checking(new Expectations() {
			{
				//exptectations go here
				oneOf(hello).hello();
				oneOf(hello).world();
				oneOf(hello).sayHello(msg);
				will(returnValue("Hello BT"));
			}
		});
		
		//3. code being tested
		String result = tdd.sayHello(msg);
		
		//4.assertions.... 
		org.junit.Assert.assertEquals("[Hello BT]", result);
	}
	
	//JMock expectations do two things: 
	//test that they receives the expected method invocations 
	//and stub the behaviour of those methods. 
	
	/**
	 * Expectation—When we’re talking about mock objects, 
	 * an Expectation is a feature built into the mock that verifies 
	 * whether the external class calling this mock has the correct behavior.
	 * 
	 * An expectations block can contain any number of expectations.
	 * Each expectation has the following structure:
	 * 
	 * invocation-count(mock-object).method(argument-constraints);
	 * inSequence(sequence-name);
	 * when(state-machine.is(state-name));
	 * will(action);
	 * then(state-machine.is(new-state-name));
	 * 
	 * Except for the invocation count and the mock object, all clauses are optional. 
	 * You can give an expectation as many inSequence, when, will and then clauses as you wish.
	 * 
	 */
	@Ignore
	@Test
	public void expectation() {
	}
	
	@Test
	public void testSequence() {
		final Sequence sequence = context.sequence("hello-jmock");
		final HelloJmock hello = context.mock(HelloJmock.class, "HelloJmock.class");
		TddDemo tdd = new TddDemo(hello);
		context.checking(new Expectations(){
			{
				atLeast(1).of(hello).hello();
				inSequence(sequence);
				oneOf(hello).world();
				inSequence(sequence);
				oneOf(hello).sayHello("World");will(returnValue("Hello World"));
			}
		});
		
		String result = tdd.sayHello("World");
		Assert.assertEquals("[Hello World]", result);
	}

}
