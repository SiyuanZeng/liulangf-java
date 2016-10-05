package com.liulangf.recursion;

/**
 * The transformation from recursion to iteration is one of the most fundamental concepts of computer science. --D. Knuth 1974
 * <ul>
 *   <li>Tail recursion can be immediately converted into iteration(loop).</li>
 *   <li>Other forms of recursion require program transformation techniques and possibly more complex data structures.</li>
 * </ul>
 * 
 * 
 * Functional programming relies on recursive functions heavily since imperative looping structures are frowned upon. 
 * However, recursion chews up a valuable and limited resource – the stack – and can lead to an unrecoverable type of 
 * CLR error: the dreaded StackOverflow. Tail Recursion however is a form of recursion that doesn’t use any stack space, 
 * and thus is a way to use recursion safely.
 * 
 * Tail Recursion is a specialized type of recursion where there is a guarantee that nothing is left to execute in the 
 * function after a recursive call. In other words, the function returns the result of a recursive call.
 * 
 * 
 * The important thing to note about tail-recursive functions is that they can run in loops without consuming 
 * stack space. Such function are oden called “iterative functions.” --Joe Armstrong.
 * 
 * 
 * When a recursion function returns the result of its recursion call, there is no need to maintain 
 * a stack of activation records.
 * 
 * (define last (lambda (x)
 *   (cond ((null ? x) '())
 *         ((null ? (cdr x)) (car x))
 *         (else (last (cdr x))))))
 *         
 *         
 *  
 * Tail Recursion = 
 * 
 * @author YuQing Liu
 *
 */
public class TailRecursion {
	
	/**
	 * Naive recursive factorial.
	 * 
	 * (define(fact1 n))
	 * ;; naive recursive factorial
	 * (if(< n 1)
	 *     1
	 *     (* n (fact1(sub 1 n)))))
	 *     
	 * @return
	 */
	String factorialInSchema1() {
		StringBuilder whatIsGoingOn = new StringBuilder();
		whatIsGoingOn
		    .append("fact1 6 =>")
		    .append("|(fact1 6)")
		    .append("| (fact1 5)")
		    .append("||(fact1 4)")
		    .append("|| (fact1 3)")
		    .append("|||(fact1 2)")
		    .append("||| (fact1 1)")
		    .append("||||(fact 1 0)")
		    .append("||||1")
		    .append("||| 1")
		    .append("|||2")
		    .append("|| 6")
		    .append("||24")
		    .append("| 120")
		    .append("|720")
		    .append("720");
		return whatIsGoingOn.toString();
	}
	
	/**
	 * Tail recursive factorial.
	 * 
	 * (define(fact2 n))
	 * ;rewrite to just call the tail-recursive
	 * ;factorial with the appropriate initial values
	 * (fact2-helper n 1)
	 * 
	 * (define(fact2-helper n accumulator)
	 * ;tail recursive factorial calls itself as
	 * ;the last thing to be done
	 * (if(< n 1))
	 *   accumulator
	 *   (fact2-helper(sub1 n)(* accumulator n))))
	 *   
	 *   
	 * <ul>
	 *   <li>The fact2-helper is a recursive call.</li>
	 *   <li>Instead of pushing information on the stack, it reassigns the local variables and jumps to the beginning of the procedure.</li>
	 *   <li>Thus, the recursion is automatically transformed iinto iteration.</li>
	 * </ul>
	 * 
	 * @return
	 */
	String factorialInSchema2() {
		StringBuilder whatIsGoingOn = new StringBuilder();
		whatIsGoingOn.append("(fact2 6) => ")
		    .append("|(fact2 6)")
		    .append("|(fact2-helper 6 1)")
		    .append("|(fact2-helper 5 6)")
		    .append("|(fact2-helper 4 30)")
		    .append("|(fact2-helper 3 120)")
		    .append("|(fact2-helper 2 360)")
		    .append("|(fact2-helper 1 720)")
		    .append("|(fact2-helper 0 720)")
		    .append("|720")
		    .append("720");
		
		return whatIsGoingOn.toString();
	}
	
}
