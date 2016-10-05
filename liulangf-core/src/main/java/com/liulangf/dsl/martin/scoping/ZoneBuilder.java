/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.scoping;

/**
 * @author Quqing Liu
 */
public class ZoneBuilder {
	private Zone zone;
	
	public ZoneBuilder allow(RuleElement... rules) {
		return this;
	}
	
	protected RuleElement department(String name) {
		return null;
	}
	
	protected RuleElement until(int year, int month, int day) {
		return null;
	}
	
	protected RuleElement gradeAtLeast(String grade) {
		return null;
	}
	
	protected RuleElement refuse(RuleElement element) {
		return null;
	}
	
	public Zone getValue() {
		return zone;
	}

}
