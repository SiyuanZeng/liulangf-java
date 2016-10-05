package com.liulangf.recursion.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuQing Liu
 *
 */
public class Fibonacci {
	
	private final static transient Logger LOGGER = LoggerFactory.getLogger(Fibonacci.class);
	
	/**
	 * F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*)
	 * 
	 * @param n
	 * @return
	 */
	public long fibonacci(int n) {
		return fibonacci(n, 0, 1);
	}
	
	private long fibonacci(int n, int x, int y) {
		LOGGER.info("fibonacci({}, {}, {})", new Object[] {n, x, y});
		if (n <= 2) {
			return x + y;
		}
		
		return fibonacci(n - 1, y, x + y);
	}
	
	public static void main(String...args) {
		LOGGER.info("{}", new Fibonacci().fibonacci(6));
//		fibonacci(6, 0, 1)
//		fibonacci(5, 1, 1)
//		fibonacci(4, 1, 2)
//		fibonacci(3, 2, 3)
//		fibonacci(2, 3, 5)
//		8
	}

}
