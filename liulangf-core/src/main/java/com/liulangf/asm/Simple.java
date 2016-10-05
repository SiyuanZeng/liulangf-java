package com.liulangf.asm;

public class Simple {
	
	private int age;
	
	public void check(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			throw new IllegalArgumentException();
		}
	}

}
