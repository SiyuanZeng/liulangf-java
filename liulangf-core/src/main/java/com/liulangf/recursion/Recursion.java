package com.liulangf.recursion;

/**
 * References: Thomas A. Anastasio, Richard Chang.
 * 
 * Recursion is a technique that allows us to break down a problem into 
 * one or more subproblems that are similar in form to the original problem.
 * 
 * The recursive functions are characterized based on:
 * <ul>
 *   <li>whether the function calls itself or not(direct or indirect recursion).</li>
 *   <li>whether there are pending operations at each recursive call(tail-recursive or not)</li>
 *   <li>the shape of the calling pattern-whether pending operations are also recursive (liner or tree-recursive).</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class Recursion {
	
	/**
	 * A function is directly recursive if it contains an explicit call to itself.
	 */
	int directRecursion(int x) {
		if (x <= 0) return x;
		
		return directRecursion(x - 1);
		
	}
	
	/**
	 * A function indirectRecursion is indirectly recursive if it contains a call to another function
	 * which ultimately calls indirectRecursion.
	 * 
	 * The following pair of functions is indirectly recursive. Since they call each other, 
	 * they are also known as mutually recursive functions. 
	 */
	int indirectRecursion(int x) {
		if (x <= 0) return x;
		return bar(x);
	}
	
	int bar(int y) {
		return indirectRecursion(y - 1);
	}
	
	/**
	 * A recursive function is said to be tail recursive if there are no pending operations to be 
	 * performed on return from a recursive call.
	 * 
	 * Tail recursive functions are often said to "return the value of the last recursive call as the value of 
	 * the function." Tail recursion is very desirable because the amount of information which must be stored 
	 * during the computation is independent of the number of recursive calls. Some modern computing systems 
	 * will actually compute tail-recursive functions using an iterative process.
	 * 
	 * @return
	 */
	int tailRecursion() {
		return 0;
	}

	/**
	 * A non-tail recursive function can often be converted to a tail-recursive function by means of an "auxiliary"(辅助的) 
	 * parameter. This parameter is used to form the result. The idea is to attempt to incorporate the pending operation 
	 * into the auxiliary parameter in such a way that the recursive call no longer has a pending operation. 
	 * The technique is usually used in conjunction with an "auxiliary" function. This is simply to keep the syntax 
	 * clean and to hide the fact that auxiliary parameters are needed.
	 * 
	 */
	void convertingRecursiveFunctionsToBeTailRecursive() {
	}

	/**
	 * For example, a tail-recursive Fibonacci function can be implemented by using two auxiliary parameters 
	 * for accumulating results. It should not be surprising that the tree-recursive fib function requires two 
	 * auxiliary parameters to collect results; there are two recursive calls. To compute fib(n), call fib_aux(n 1 0)
	 * 
	 * @param n
	 * @param next
	 * @param result
	 * @return
	 */
	int tailFibonacci(int n, int next, int result) {
		if (n == 0) return result;
		return tailFibonacci(n - 1, next + result, next);
	}
	
}

class PendingOperation {
	
	/**
	 * Notice that there is a "pending operation," namely multiplication, to be performed on return 
	 * from each recursive call. Whenever there is a pending operation, the function is non-tail-recursive. 
	 * Information about each pending operation must be stored, so the amount of information is not independent 
	 * of the number of calls.
	 * 
	 * @param n
	 * @return
	 */
	int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n - 1);
	}
	
	int factorial2(int n) {
		return tail(n, 1);
	}
	
	/**
	 * Note that tail has no pending operations on return from recursive calls. 
	 * The value computed by the recursive call is simply returned with no modification. 
	 * The amount of information which must be stored is constant (the value of n and the value of result), 
	 * independent of the number of recursive calls.
	 * 
	 * @param n
	 * @param result
	 * @return
	 */
	int tail(int n, int result) {
		if (n == 1) {
			return result;
		}
		return tail(n -1, n * result);
	}
	
}

/**
 * Another way to characterize recursive functions is by the way in which the recursion grows. 
 * The two basic ways are "linear" and "tree."
 * 
 * The tree recursive fib() method is "Big O 2^n" (O(2^n)) algorithm. In other words as n increases 
 * the problem size roughly doubles. On the other hand, a linearly recursive algorithm would be O(n). 
 * In other words, the amount of work required roughly increases linearly. 
 * 
 * @author YuQing Liu
 */
class LinearAndTreeRecursion {
	
	/**
	 * A recursive function is said to be linearly recursive when no pending operation involves another 
	 * recursive call to the function. Such as factorial.
	 * 
	 */
	void linearlyRecursive() {
	}
	
	/**
	 * A recursive function is said to be tree recursive (or non-linearly recursive) when the pending operation 
	 * does involve another recursive call to the function. Such as Fibonacci.
	 */
	void treeRecursive() {
	}
	
	/**
	 * Notice that the pending operation for the recursive call is another call to fibonacci. 
	 * Therefore fibonacci is tree-recursive.
	 * 
	 * @param n
	 * @return
	 */
	int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
}