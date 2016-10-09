package com.liulangf.refactor.smell;

/**
 * Conditional logic is often the trickiest part of such code.
 * 
 * <ul>
 *   <li>It's hard to reason about, since we have to consider multiple paths through the code.</li>
 *   <li>It's tempting to add special-case handling rather than develop the general case.</li>
 *   <li>Conditional logic sometimes is used as a weak substitute for object-oriented mechanisms.</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class ConditionalLogic {
	
	/**
	 * If there's a reasonable default value, use that.
	 * Otherwise, Introduce Null Object to create a default object that you explicitly use.
	 */
	void nullCheck() {}
	
	/**
	 * Code has complex conditions involving and, or, and not.
	 * 
	 * Apply DeMorgan's Law:
	 *  ! (a && b)  => (!a) || (!b)
	 *  ! (a || b)  =>  (!a) && (!b)
	 *  
	 *  ~(A or B) = ~A and ~B
	 *  ~(A and B) = ~A or ~B
	 *  
	 * You may find that some variables will communicate better if they change names to reflect their flipped sense.
	 * <ul>
	 *   <li>Introduce Explaining Variable to make each clause clearer.</li>
	 *   <li>Use guard clauses to peel off certain conditions; the remaining clauses get simpler.</li>
	 *   <li>Decompose Conditional to pull each part into its own method.</li>
	 * </ul>
	 */
	void complicatedBooleanExpression() {}
	
	/**
	 * Symptoms:
	 *   Complex if statements.
	 *   Checks for particular values before doing work (especially comparisons to constants or enumerations)
	 *   
	 * Reforting:
	 *   If the conditionals are taking the place of polymorphism, Replace Conditional with Polymorphism.
	 *   If the if and then clauses are similar enough, you may be able to rewrite them so that the same code fragment 
	 *     can generate the proper results for each case; then the conditional can be eliminated.
	 * 
	 */
	void specialCase() {}
	
	/**
	 * Switch Statements.
	 * 
	 */
	void simulatedInheritance() {}

}
