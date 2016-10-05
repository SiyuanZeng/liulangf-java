package com.liulangf.recursion.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factorial: 
 * f(n) = f(n-1) * n;
 * f(0) = 1;
 * 
 * @author YuQing Liu
 *
 */
public class Factorial {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(Factorial.class);
	
	public long factorial(int n) {
		return factorial(n, 1);
	}
	
	/**
	 * Tail recursive factorial.
	 * 
	 * @param n
	 * @param sum local variable for stack.
	 * @return
	 */
	private long factorial(int n, int sum) {
		LOGGER.info("factorial({}, {})", n, sum);
		if (n <= 1) {
			return sum;
		}
		
		return factorial(n-1, n*sum); 
	}
	
	/**
	 * Loop style factorial.
	 * @param n
	 * @param sum
	 * @return
	 */
	public long factorial2(int n, int sum) {
		int N,M;
		N = n; M = sum;
		while (!(N <=1)) {
			M = N * M;
			N = N - 1;
		}
		return M;
	}
	
	public static void main(String...args) {
		LOGGER.info("{}", new Factorial().factorial(10));
	}

}
