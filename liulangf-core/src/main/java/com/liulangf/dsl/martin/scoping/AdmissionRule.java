package com.liulangf.dsl.martin.scoping;

/**
 *
 * @author Quqing Liu
 */
public abstract class AdmissionRule {
	protected RuleElement body;
	public AdmissionRule(RuleElement body) {
		this.body = body;
	}
	public abstract AdmissionRuleResult canAdmit(Employee e);
}
