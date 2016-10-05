/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin;

/**
 * http://martinfowler.com/bliki/ExpressionBuilder.html
 * 
 *  An expression builder is a separate object on which we define the fluent interface 
 *  that then translates the fluent calls to the underlying regular API calls.
 *  
 *  <<Domain Specific Language>> by Martin Fowler.
 *  Expression Builders are objects whose sole task is to build up a model of normal objects
 *  using a fluent interface - effectively translating fluent sentences into a sequence of 
 *  command-query API calls.
 *  
 *  Expression Builder: An object, or family of objects, that provides a fluent interface over 
 *  a normal command-query API.
 *  
 *  An Expression Builder provides a fluent interface as a separate layer on top of regular API.
 *  This way you have both styles of interface and the fluent interface is clearly isolated,
 *  making it easier to follow.
 *  
 *  An Expression Builder is an object that provides a fluent interface which it then translates into calls 
 *  on an underlying command-query API. You can think of it as a translation layer that translates the 
 *  fluent interface into the command-query API. An Expression Builder is often a Composite [gof] using 
 *  child Expression Builders to build subexpressions within an overall clause.
 *  
 *  Exactly how you arrange Expression Builders depends very much of the kind of clause you are dealing with. 
 *  Method Chaining is a sequence of method calls, each returning an Expression Builder; 
 *  Nested Function may use an Expression Builder that is a superclass or a set of global functions.
 *  
 *  One of the most notable questions is whether to have a single Expression Builder object for the whole DSL, 
 *  or whether to use multiple Expression Builders for different parts of the DSL. 
 *  Multiple Expression Builders usually follow a tree structure that really is a syntax tree for the DSL. 
 *  The more complex the DSL, the more valuable a tree of Expression Builders is.
 *  
 *  <<Pragmatic.Bookshelf.The.ThoughtWorks.Anthology.Mar.2008>>
 *  Expression Builder :
 *  A way of avoiding these classes between DSLs and regular APIs is to use the Expression Builder pattern.
 *  Essentially this says that the methods that are used in a DSL should be defined on a separate object 
 *  that creates the real domain object.
 *  
 *
 * @author Quqing Liu
 */
public class ExpressionBuilder {
	
	/**
	 * One of the problems with a FluentInterface is that it results in some odd looking methods.
	 * 
	 * Methods like with, skippable, and priorityRush don't sit well on the Order class. 
	 * The naming works well in the context of the little DomainSpecificLanguage that the fluent interface provides, 
	 * but we usually expect methods to make sense in their own right. The methods violate the CommandQuerySeparation 
	 * which in Java means that methods that change the ObservableState of an object shouldn't have a return value. 
	 * If we supply methods that make more individual sense, like addLine, we also go against the notion of a 
	 * MinimalInterface.
	 *  
	 * At the heart of all this is a mismatch between what a fluent interface needs and our usual guidelines 
	 * for API design. What works well for a regular API doesn't work for a fluent one and vice versa.
	 */
	void problem() {
		//odd looking methods.
		Order order = 
		newOrder()
		    .with(6, "TAL")
		    .with(5, "HPK").skippable()
		    .with(3, "LGV")
		    .priorityRush()
		    .getSubject();
		order.toString();
	}
	
	OrderBuilder newOrder() {
		return new OrderBuilder();
	}
	
	/**
	 * For an interesting open example of expression builder, take a look at the JMock library. 
	 * They use an interesting variant of this approach to handle their little DSL for expectations. 
	 * There is a single expression builder object (InvocationMockerBuilder). As usual with a single builder object, 
	 * every call to a builder method ends with a return this to continue the method chaining. 
	 * The interesting twist is that the return type varies, depending on which part of the expression we are in. 
	 * The returning interface provides only the methods that make sense for that part of the expression. 
	 * This supports better error checking, and also means that the method completion you find on IDEs works better 
	 * by only suggesting methods that are legal at that point of the expression.
	 */
	void expression_builder_in_jmock() {
		
	}
}

/**
 *  An expression builder is a separate object on which we define the fluent interface 
 *  that then translates the fluent calls to the underlying regular API calls.
 */
class OrderBuilder {
	private Order subject = new Order();
	private OrderLine currentLine;
	public OrderBuilder with(int quantity, String productCode) {
		currentLine = new OrderLine(quantity, productCode);
		subject.addLine(currentLine);
		return this;
	}
	public OrderBuilder skippable() {
		currentLine.setSkippable(true);
		return this;
	}
	public OrderBuilder priorityRush() {
		subject.setRush(true);
		return this;
	}
	public Order getSubject() {
		return subject;
	}
}

class Order {
	public void addLine(OrderLine line){}
	public void setRush(boolean rush) {}
}

class OrderLine {
	public OrderLine(){}
	public OrderLine(int quantity, String productCode) {}
	
	public void setSkippable(boolean skippable) { }
}