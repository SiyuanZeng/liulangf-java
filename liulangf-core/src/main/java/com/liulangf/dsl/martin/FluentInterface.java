package com.liulangf.dsl.martin;

/**
 * The essence of fluent interfaces is that they approach thinking about using components differently.
 *
 * @author Quqing Liu
 */
public class FluentInterface {
	
	/**
	 * For many people the central pattern of a fluent interface is that of Method Chaining. A normal API might
	 * have code like this:
	 * <pre>
	 *   Processor p = new Processor(2, 2500, Processor.Type.i386);
	 *   Disk d1 = new Disk(150, Disk.UNKNOWN_SPEED, null);
	 *   Disk d2 = new Disk(75, 7200, Disk.Interface.SATA);
	 *   return new Computer(p, d1, d2);
	 * </pre>
	 * 
	 * With Method Chaining, we can express the same thing with:
	 * <pre>
	 *   computer()
	 *       .processor()
	 *           .cores(2)
	 *           .speed(2500)
	 *           .i386()
	 *       .disk()
	 *           .size(150)
	 *       .disk()
	 *           .size(75)
	 *           .speed(7200)
	 *           .sata()
	 *       .end();
	 * </pre>
	 */
	void method_chaining() {
	}
	
	/**
	 * Method chaining isn't the only way to get this sense of flow. Here is the same thing using
	 * a sequence of method call statements, which I call Function Sequence:
	 * <pre>
	 *   computer();
	 *       processor();
	 *           cores(2);
	 *           speed(2500);
	 *           i386();
	 *       disk();
	 *           size(150);
	 *       disk();
	 *           size(75);
	 *           speed(7200);
	 *           sata();
	 *       end();   
	 * </pre>
	 * 
	 */
	void function_sequence() {
	}

	/**
	 * Command-query api : none fluent api.
	 * Command-query separation says that the various methods on an object should be divided into
	 * commands and queries.
	 * 
	 * A query is a method that returns a value, but does not change the observable state of the system.
	 * A command may change the observable state, but should not return a value.
	 * 
	 * Command-query separation is an extremely valuable principle in programming.
	 * One of the consequences of using Method Chaining in internal DSLs is that it usually breaks this principle-
	 * each method alters state but return an object to continue the chain.
	 * 
	 * But fluent interfaces follow a different set of rules.
	 * 
	 * Another important difference between a command-query and fluent interface is the naming of the methods.
	 * With DSL naming, it's sentence that comes first; the elements are named to fit in with that context.
	 * DSL names are written with the context of the specific DSL in mind, while command-query names are written
	 * to work without any context.
	 * 
	 */
	void command_query_separation() {
	}

	/**
	 * If you mix both styles of interface on the same class, it's confusing.
	 * I therefore advocate keeping the language-handling elements of a DSL separate from regular command-query
	 * objects by building a layer of Expression Builders over regular objects.
	 * 
	 * Expression Builders are objects whose sole task is to build up a model of normal objects using 
	 * a fluent interface-effectively translating fluent sentences into a sequence of command-query API calls.
	 * 
	 * The input for the Expression Builders is a stream of function calls.
	 */
	void expressoin_builders() {
	}
	

	/**
	 * Nested Function is a third function combination technique that can often avoid
	 * Context Variables. Using Nested Function, the computer configuration example looks like this:
	 * <pre>
	 *   computer(
	 *       processor(
	 *           cores(2),
	 *           speed(2500),
	 *           i386
	 *       ),
	 *       disk(
	 *           size(150)
	 *       ),
	 *       disk(
	 *           size(75),
	 *           speed(7200),
	 *           SATA
	 *       )
	 *   );
	 * </pre>
	 * 
	 * Nested Function combines functions by making function calls arguments in higher-level function calls.
	 * The result is a nesting of function invocations.
	 */
	void nested_function() {
	}

}
