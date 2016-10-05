/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl;

/**
 * Just a Demo for Internal DSL.
 * 
 * @author Quqing Liu
 */
public class Mailer {
	private Mailer() {}
	
	public static Mailer mail() {
		return new Mailer();
	}
	
	public Mailer to(String des) {
		return this;
	}
	
	public Mailer from(String from) {
		return this;
	}
	
	public Mailer subject(String title) {
		return this;
	}
	
	public Mailer body(String content) {
		return this;
	}
	
	public void send() {
	}

}
