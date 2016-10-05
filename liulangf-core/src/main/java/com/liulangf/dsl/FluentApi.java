/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl;

import static com.liulangf.dsl.TableCell.TableCellBuilder.row;


/**
 * http://www.infoq.com/news/2007/11/Extension-Methods-DSL
 * http://www.infoq.com/articles/internal-dsls-java
 * http://martinfowler.com/bliki/FluentInterface.html
 * 
 * It is important to note as well that it is difficult to differentiate between a DSL and an API.
 * In the case of internal DSLs, they are essentially the same. When thinking in terms of DSL, we 
 * exploit the host language to create a readable API with a limited scope. 
 * 
 * "Internal DSL" is more or less a fancy name for an API that has been created thinking in terms of 
 * readability and focusing on a particular problem of a specific domain.
 * 
 * Fluent interface : emphasizes the fact that an internal DSL is really just a particular kind of API,
 * designed with this elusive quality of fluency.
 * 
 * Any internal DSL is limited to the syntax and structure of its base language. In the case of Java, 
 * the obligatory use of curly braces, parenthesis and semicolons, and the lack of closures and meta-programming 
 * may lead to a DSL that is more verbose that one created with a dynamic language.
 * 
 * <ul>
 *   <li>Method Chaining</li>
 *   <li>static factory method</li>
 * </ul>
 *
 * http://msdn.microsoft.com/zh-cn/magazine/ee291514.aspx

 * @author Quqing Liu
 */
public class FluentApi {
	
	/**
	 * Fluent interfaces are implemented using method chaining.
	 * The central pattern of a fluent interface is that of Method chaining. 
	 * 
	 * It is important to note that method chaining by itself is not enough to create a DSL.
	 * In addition to method chaining, static factory methods and imports are a great aid in creating a compact, 
	 * yet readable DSL. 
	 * 
	 * There are two approaches to create a DSL using method chaining, and both are related to the return 
	 * value of the methods in the chain.(Return this or return an intermediate object)
	 * 
	 * Return this:
	 * <ul>
	 *   <li>Chaining of related object behavior</li>
	 *   <li>simple construction/configuration of an object - A common builder object.</li>
	 * </ul>
	 * 
	 * Return an intermediate object: has some advantages over returning this:
	 * <ul>
	 *   <li>We can use the compiler to enforce business rules.(e.g. required fields)</li>
	 *   <li>we can guide our users of the fluent interface through a specific path by limiting the available 
	 *       options for the next element in the chain</li>
	 *   <li>gives API creators greater control of which methods a user can (or must) call, as well as 
	 *       the order and how many times a user of the API can call a method</li>
	 * </ul>
	 */
	void methodChaining() {
		//StringBuilder method chaining, but not DSL.
		StringBuilder b = new StringBuilder();
		b.append("Hello. My name is ")
		    .append("Liuyuqing ")
		    .append("and my age is")
		    .append(100);
	}
	
	/**
	 *  Static factory methods, when used with static imports, can help us create more compact fluent interfaces.
	 *  We have found that static factory methods are a convenient way to simulate named parameters(命名参数) in Java, 
	 *  a feature that many developers wish the language had.
	 *  
	 *  On the bright side, we can simulate them by using a static factory method and static imports.
	 */
	void staticFactory() {
		//import static row, more readable codes
		printCell(row(6).column(8));
		//in groovy we can use named parameter
		//printCell(row: 6, column: 8)
	}

	void printCell(TableCell cell) {
		//
	}
	
	/**
	 * Groovy supports NamedParameter.
	 */
	void namedParameter() {
		//Car bmw = new Car(model : "BMW", color : "black"); 
	}
	
	/**
	 * http://msdn.microsoft.com/en-us/magazine/ee291514.aspx
	 * 
	 * Semantic Model:
	 * 
	 * 
	 * Fluent Interfaces and Expression Builders
	 * A fluent interface is a style of API that uses method chaining to create a easy, readable syntax.
	 * The simplest and perhaps most common trick in making a fluent interface is to simply make an object 
	 * return itself from method calls (this is largely how jQuery works).
	 * 
	 * In a more complicated scenario you may separate the fluent interface into two parts, 
	 * the semantic model that supplies the runtime behavior and a series of “Expression Builder” classes 
	 * that implement the DSL grammars. I use an example of this pattern in 
	 */
	void other_voice() {
	}

}

/**
 * http://www.jroller.com/alexRuiz/entry/simulating_named_parameters_in_java
 * simulating_named_parameters_in_java
 */
class TableCell {
	private final int row;
	private final int column;
	
	private TableCell(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	static class TableCellBuilder {
		private final int row;
		
		private TableCellBuilder(int row) {
			this.row = row;
		}
		
		public static TableCellBuilder row(int row) {
			return new TableCellBuilder(row);
		}
		
		public TableCell column(int column) {
			return new TableCell(row, column);
		}
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
}
