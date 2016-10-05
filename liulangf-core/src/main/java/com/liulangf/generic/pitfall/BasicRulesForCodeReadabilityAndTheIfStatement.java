package com.liulangf.pitfall;

/**
 * http://united-coders.com/christian-harms/basic-rules-for-code-readability-and-the-if-statement
 * 
 * 
 * @author liulangf
 *
 */
public class BasicRulesForCodeReadabilityAndTheIfStatement {
	
	public void readbaleIsImportant(boolean notOk) {
		if (!notOk != false) {
			//....
		}
		
		//=>
		if (!notOk == true) {
		}
		
		//=>
		if (!notOk) {
		}
		
		//=>
		boolean isOk = !notOk;
		if (isOk) {
			//....
		}
	}
	
	private void f() {}
	
	/**
	 * if-if-if trees
	 */
	public void ifififTrees() {
		boolean a = false, b = false, c = false;
		if (a) {
			if (!b) {
				if (c) {
					f();
				}
			}
		}
		//=>
		if (a) if (!b) if (c) { f(); }
		
		//=>
		if (a && !b && c) {
			f();
		}
	}
	
	public void nullChecks(String msg) {
		if (msg != null && msg.equals("yes")) {
			//...
		}
		
		//=>
		if ("yes".equals(msg)) {
			//...
		}
	}
	

}
