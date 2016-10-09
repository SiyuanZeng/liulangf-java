package com.liulangf.dsl.martin;

/**
 * http://martinfowler.com/dslCatalog/
 * My book on Domain Specific Languages uses a pattern structure to organize the concepts that I use to describe DSLs.
 * 
 * List of DSL Patterns:
 * Internal DSL topics:
 * <ul>
 * <li>Expression Builder</li>
 * <li>Function Sequence</li>
 * <li>Nested Function</li>
 * <li>Method Chaining</li>
 * <li>Object Scoping</li>
 * <li>Closure</li>
 * <li>Nested Closure</li>
 * <li>Literal List</li>
 * <li>Literal Map</li>
 * <li>Dynamic Reception</li>
 * <li>Annotation</li>
 * <li>Parse Tree Manipulation</li>
 * <li>Class Symbol Table</li>
 * <li>Textual Polishing</li>
 * <li>Literal Extension</li>
 * </ul>
 * 
 * External DSL Topics:
 * <ul>
 * <li>Delimiter-Directed Translation</li>
 * <li>BNF</li>
 * <li>Syntax-Directed Translation</li>
 * <li>Regex Table Lexer</li>
 * <li>Recursive Descent Parser</li>
 * <li>Parser Combinator</li>
 * <li>Parser Generator</li>
 * <li>Tree Construction</li>
 * <li>Embedded Interpretation</li>
 * <li>Embedded Translation</li>
 * <li>Foreign Code</li>
 * <li>Alternative Tokenization</li>
 * <li>Nested Operator Expression</li>
 * <li>Newline Separators</li>
 * </ul>
 * 
 * Common Topics
 * <ul>
 * <li>Semantic Model</li>
 * <li>Symbol Table</li>
 * <li>Context Variable</li>
 * <li>Construction Builder</li>
 * <li>Macro</li>
 * <li>Notification</li>
 * </ul>
 * 
 * Alternative Computational Model:
 * <ul>
 *   <li>Adaptive Model</li>
 *   <li>Decision Table</li>
 *   <li>Dependency Network</li>
 *   <li>Embedment Helper</li>
 *   <li>Generation Gap</li>
 *   <li>Model Ignore Generation</li>
 *   <li>Model-Aware Generation</li>
 *   <li>Production Rule System</li>
 *   <li>State Machine</li>
 *   <li>Template Generation</li>
 *   <li>Transformer Generation</li>
 * </ul>
 * 
 *
 * @author Quqing Liu
 */
public class DSLByMartinFowler {
	

	/**
	 * Domain-specific language(noun): a computer programming language of limited expressiveness 
	 * focused on a particular domain.
	 * 
	 * Martin Fowler divides the DSLs into three main categories:
	 * <ul>
	 *   <li>external DSLs</li>
	 *   <li>internal DSLs</li>
	 *   <li>language workbenches</li>
	 * </ul>
	 * 
	 * A Language workbench is a specialized IDE for defining and building DSLs.
	 * 
	 * Don't try to make the DSL read like natural language. The trouble is that such attempts lead to 
	 * a lot of syntactic sugar which complicates understanding of the semantics.
	 *
	 * @author Quqing Liu
	 */
	class DomainSpecificLanguage {
		
		//The central pattern of a fluent interface is that of Method chaining.
		void internalDSL() {
			System.out.println("Internal DSL, Fluent interface, language-like api");
		}
	}

}
