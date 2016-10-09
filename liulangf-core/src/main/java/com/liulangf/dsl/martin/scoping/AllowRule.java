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
