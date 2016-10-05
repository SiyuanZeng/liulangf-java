/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.basic;

/**
 * A semaphore is a primitive(原语) used to provide synchronization between various processes 
 * or between the various threads in a given process. 
 * 
 * binary semaphore : 0 & 1
 * 
 * @author Quqing Liu
 */
@Contention
public class Semaphores {
	
	/**
	 * P, V 原语?? 
	 * semaphore_wait() & semaphore_post()
	 * 
	 * There are 3 operations that a process can perform on a semaphore:
	 *   1. Create a semaphore with the initial value.
	 *   2. Wait for a semaphore. This tests the value of the semaphore, waits(blocks) if 
	 *      the value is less than or equal to 0, and then decrements the semaphore value 
	 *      once it is greater than 0. The pseudocode is :
	 *   <pre>
	 *       while (semaphore_value <= 0) {
	 *           //wait; i.e., block the thread or process
	 *           ;
	 *       } 
	 *       semaphore_value--;
	 *       //we have the semaphore
	 *   </pre>
	 *   3. Post to a semaphore. This increments the value of the semaphore.
	 *     semaphore_value++;
	 *     
	 *  <ul>
	 *    <li>Binary semaphore	: can be used for mutual exclusion, just like a mutex.</li>
	 *    <li>Counting semaphore: </li>
	 *  </ul>
	 *  
	 */
	public void perform() {
	}

}
