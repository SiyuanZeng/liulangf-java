/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.behavioral.command;

/**
 *
 * @author Quqing Liu
 */
public class Client {

	public static void main(String... args) {

		//Command 的调用框架(template)
		Invoker invoker = new Invoker();
		//1.Command pattern 的灵活性
		//2.分层可以解决任何问题
		invoker.invoke(new Command() {
			public void execute() {
				new SystemA().actionA();
			}
		});
		
		invoker.invoke(new Command() {
			public void execute() {
				new SystemB().actionB();
			}
		});
	}
}
