/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.recursion;

/**
 * 
 * 
 * @author YuQing Liu
 */
public class WhileLoop {

	/**
	 * While Loop is a special form of recursion.
	 * 
	 * W is the while statement.
	 * T is the test
	 * L is the instruction list.
	 * 
	 * The formal definition of W is 
	 *   W == if(T) {L; W;}
	 *   Notice that the WHILE statement W is defined in terms of itself.
	 */
	public void whileLoop() {}
	

	/**
	 * Form of recursion in which the recursive call is the last instruction in the method.
	 * 
	 * <pre>
	 *   void pickAllBeepers() {
	 *       if (nextToABeeper()) {
	 *           pickBeeper();
	 *           pickAllBeepers();//Recursive call is the last instruction.
	 *       }
	 * </pre>
	 * 
	 * Tail recursion and while loop:
	 * Execution equivalent with:
	 * <pre>
	 *   void pickAllBeepers() {
	 *       while(nextToABeeper()) {
	 *           pickBeeper();
	 *       }
	 *   }
	 * </pre>
	 * 
	 */
	public void tailRecursionAndWhileLoop() {}

}
