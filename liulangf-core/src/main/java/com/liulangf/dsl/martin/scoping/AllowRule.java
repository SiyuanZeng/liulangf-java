/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.scoping;

/**
 *
 * @author Quqing Liu
 */
public class AllowRule extends AdmissionRule {
	
	public AllowRule(RuleElement body) {
		super(body);
	}
	
	@Override
	public AdmissionRuleResult canAdmit(Employee e) {
		return body.eval(e) 
		    ? AdmissionRuleResult.admit
		    : AdmissionRuleResult.no_option;
	}
	
}
