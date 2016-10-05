/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.refactor.smell;

/**
 * Duplication has been recognized for more than 30 years as the bane of the programmer's lot. 
 * How does duplication cause problems?
 * 
 * <ul>
 *   <li>There is more code to maintain(a conceptual and physical burden).</li>
 *   <li>Parts that vary are buried inside the parts that stay the same (a perceptual problem—it's hard to see the important stuff).</li>
 *   <li>Code variations often hide deeper similarities—it will be hard to see the deeper solution among all the similar code.</li>
 *   <li>There's a tendency to fix a bug in one place and leave identical bugs elsewhere unfixed. 
 *       When you see two variations of something, it's hard to know which variation is the right pattern or if there's a good reason for the variations.</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class Duplication {
	
	/**
	 * Duplication is a root problem. Many other smells are special-case indicators of duplication. 
	 * Duplication is not always obvious, but it's critical that we address it. 
	 * Strive to make your code express each idea "once and only once."
	 */
	void onceAndOnlyOnce() {}
	
	/**
	 * <ul>
	 *   <li>The easy form: Two fragments of code look nearly identical.</li>
	 *   <li>The hard form: Two fragments of code have nearly identical effects (at any conceptual level).</li>
	 * </ul>
	 * 
	 * 
	 */
	void duplicatedCode() {}

}
