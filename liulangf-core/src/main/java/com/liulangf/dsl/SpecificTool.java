/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl;

/**
 * DSL : Domain Specific Language.
 * 
 * A specific tool for a specific job.
 * 
 * <ul>
 *   <li>Internal DSLs</li>
 *   <li>External DSLs</li>
 * </ul>
 *
 * @author Quqing Liu
 */
public class SpecificTool {
	
	/**
	 * Simple and limited.
	 * 
	 * << Domain specific >>.
	 */
	public void internalDSL() {
		Mailer.mail()
		    .from("liulangf@163.com")
		    .to("liuyuqing@tsinghua.org.cn")
		    .subject("== Hello DSL ==")
		    .body("A good thing to learn.")
		    .send();
	}
	
	/**
	 * ANTLR : building domain specific language.
	 * Flexible, Adaptable, Complicated.
	 * 
	 * <ul>
	 *   <li>1. Create ANTLR grammar</li>
	 *   <li>2. Generate lexer / parser</li>
	 *   <li>3. Parser will create parse tree</li>
	 *   <li>4. Transform parse tree to semantic model</li>
	 *   <li>5. Iterate model</li>
	 *   <li>6. Pass model element(s) to template</li>
	 * </ul>
	 */
	public void externalDSL() {
	}

	/**
	 * Why not use a DSL for building DSLs?
	 * 
	 * <ul>
	 *   <li>Model</li>
	 *   <li>Grammar : similar to EBNF</li>
	 *   <li>Xtext generator</li>
	 *   <li>Xtext Runtime</li>
	 *   <li>LL(*) Parser</li>
	 *   <li>ECore model data</li>
	 * </ul>
	 * 
	 */
	public void xtext() {
	}

}
