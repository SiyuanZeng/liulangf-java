/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.dsl.jmock;

/**
 * <<Evolving an Embedded Domain-Specific Language in Java--JMock>>
 * 
 * JMock now consists of a "builder" layer, its public API, and an "interpreter" layer that 
 * runs the definitions built with the API.
 * The jMock interpreter accepts method invocations from a test and determines how to respond based on
 * the expectations that have been set up by the builder layer.
 * 
 * Once we realised that the API had become a DSL, development became more straightforward. Firstly,
 * it encouraged a clean separation of the SYNTAX and INTERPRETATION into layers. Secondly, it freed us from 
 * following the common Java coding style where appropriate. The interpreter framework is written as normal
 * Java but we invented our own conventions for the builder level where the "call-chain" style made code read 
 * like a declarative specification instead of an imperative API.
 * 
 * Some techniques that can be used to write an Embedded DSL in a language with heavyweight syntax.
 * 
 * Separate syntax and interpretation into layers:
 * The interpretation layer should be an object-oriented framework implemented in the conventional style 
 * of the host language. The syntax layer can abuse the facilities of the host language as below:
 * <ul>
 *   <li>Use interfaces to define syntax.</li>
 *   <li>Use interface inheritance to define optional clauses</li>
 *   <li>Implement the syntax interfaces in Builder objects.</li>
 * </ul>
 *  
 * @author LiuYuqing
 */
public class EmbeddedDSL {
	
	MethodNameSyntax expects(String arg) {
		return null;
	}
	
	Stub returnValue(int value) {
		return null;
	}
	
	/**
	 * The grammar of the embedded language can be defined by interfaces. 
	 * Each interface method defines a clause and returns a reference to 
	 * the interface that defines the next clauses.
	 * 
	 * Chaining the interface types together ensures that the sequence of clauses must be:
	 * <ul>
	 *  <li>method</li>
	 *  <li>with or withAynArguments or withNoArguments</li>
	 *  <li>after</li>
	 *  <li>will</li>
	 * </ul>
	 */
	class use_interfaces_to_define_the_syntax {
		
		void and_we_got_this() {
			expects("once()")
			    .method("m")
			    .withAnyArguments()
			    .after("n")
			    .will(returnValue(20));
		}
		
	}
	
	/**
	 * To make a clause optional, define it in an interface derived from an interface that defines later clauses.
	 * 
	 * Our experience is that allowing clauses to be optional makes jMock specifications easier to read. They only
	 * need to define the expectations that are relevant to test; everything else can be left out.
	 *
	 */
	class use_interface_inheritance_to_define_optional_clauses {
		void and_we_got_this() {
			expects("once()")
			    .method("m")
			    .withAnyArguments() //no after() clause, it is optional
			    //.after("n") 
			    .will(returnValue(20));
		}
	}
	
	/**
	 * The syntax interfaces are naturally implemented according to the Builder Pattern. 
	 * The Builder classes implement the syntax interfaces by having the syntax methods create 
	 * and set up objects in the interpretation layer. 
	 * 
	 * The simplest approach is to have a single Builder class implement all the syntax interfaces.
	 * Each syntax method returns the builder object itself as the next interface in the chain.
	 */
	class implement_the_syntax_interfaces_in_builder_objects 
	        implements MethodNameSyntax, WithSyntax, OrderSyntax, StubSyntax {
		
		public WithSyntax method(String name) { return this; }
		public OrderSyntax withAnyArguments() { return this; }
		public OrderSyntax withNoArguments() { return this; }
		public OrderSyntax with() { return this; }
		public StubSyntax after(String id) { return this; }
		public void will(Stub stub) { }
	}
	
	/**
	 * An object-oriented "train-wreck" is a list of method calls chained together, often used to 
	 * navigate a data structure, as in: order.getParty().getAddress().getPhoneNumber();
	 * 
	 * In jMock, for example, one of the most startling practices is our extensive use of “train-wreck” statements. 
	 * We would normally regard this as very bad practice in object-oriented code because it violates the Law of 
	 * Demeter, exposing the internal structure of objects and increasing coupling. Train wreck statements are,
	 * however, the only way we have found to emulate a new syntax in Java or C#. We limit their use to the syntax 
	 * layer, which exists to abstract away the interpretation layer, so interface-chained code is not tightly 
	 * coupled to any implementation details.
	 */
	void train_wreck() {
		
	}

}

interface MethodNameSyntax {
	WithSyntax method(String name);
}

interface WithSyntax {
	OrderSyntax withAnyArguments();
	OrderSyntax withNoArguments();
	OrderSyntax with();
}

/**
 * Clause after(id) is optional.
 *
 */
interface OrderSyntax extends StubSyntax {
	StubSyntax after(String id);
}

interface StubSyntax {
	void will(Stub stub);
}

interface Stub {}
