package com.liulangf.tdd.junit;

public class HelloFinally {
	
	public boolean hello() {
		try {
			return true;
		} finally {
			return false;
		}
	}

}
