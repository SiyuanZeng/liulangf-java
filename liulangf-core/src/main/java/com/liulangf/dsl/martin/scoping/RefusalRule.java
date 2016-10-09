package com.liulangf.dsl.martin.scoping;

/**
 *
 * @author Quqing Liu
 */
public class RefusalRule extends AdmissionRule {
	
	public RefusalRule(RuleElement body) {
		super(body);
	}
	
	@Override
	public AdmissionRuleResult canAdmit(Employee e) {
		return body.eval(e) 
		    ? AdmissionRuleResult.refuse
		    : AdmissionRuleResult.no_option;
	}
	
}
