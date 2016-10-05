/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.scoping;

import java.util.ArrayList;
import java.util.List;

/**
 * When asked to admit an employee, the zone class runs through the admission rules in order
 *
 * @author Quqing Liu
 */
public class Zone {
	private List<AdmissionRule> rules = new ArrayList<AdmissionRule>();
	
	public void addRule(AdmissionRule e) {
		rules.add(e);
	}
	
	public boolean willAdmit(Employee e) {
		for (AdmissionRule rule : rules) {
			switch (rule.canAdmit(e)) {
			case admit :
				return true;
			case no_option :
				break;
			case refuse :
			    return false;
			default :
				throw new RuntimeException("");
		
			}
		}
		return false;
	}

}
