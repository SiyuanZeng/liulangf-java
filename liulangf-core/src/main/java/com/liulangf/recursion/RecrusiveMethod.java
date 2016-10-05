package com.liulangf.recursion;

/**
 * Process for writing Recursive methods.
 * 
 * @author YuQing Liu
 */
interface RecrusiveMethod {
	
	/**
	 * F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*)
	 * 
	 * private long fibanacci(int n, int x, int y) {
	 *   if (n <= 2) {
	 *       return x + y;
	 *   }
	 *   
	 *   return fibonacci(n - 1, y, x + y);
	 * }
	 */
	public static final RecrusiveMethod FIBONACCI = new RecrusiveMethod() {

		@Override
		public void step1() {
			//F(0) = 0, F(1) = 1;
		}

		@Override
		public void step2() {
			//if (n <= 2) {
			//	return x + y;
			//}
		}

		//return fibonacci(n - 1, y, x + y);
		@Override
		public void step3() {
			//fibonacci(6, 0, 1);
			//fibonacci(5, 1, 1);
			//fibonacci(4, 1, 2);
			//fibonacci(3, 2, 3);
			//fibonacci(2, 3, 5);
			//8
		}

		@Override
		public void step4() {
		}
		
	};
	

	/**
	 * Consider the stopping condition(the base case).
	 *   - What is the simplest case of the problem that can be solved? 
	 */
	public abstract void step1();

	/**
	 * What does the robot do in the base case?
	 */
	public abstract void step2();

	/**
	 * Find a way to solve a small piece of the larger problem if not the base case.
	 *  A. Reducing the problem in the general case.
	 *  B. The general case is that ...
	 *  C. Continue...
	 */
	public abstract void step3();

	/**
	 * Make sure the reduction leads to the base case.
	 */
	public abstract void step4();

}