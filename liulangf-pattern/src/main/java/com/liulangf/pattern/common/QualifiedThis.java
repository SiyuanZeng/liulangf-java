package com.liulangf.pattern.common;

/**
 * <<Java Language Specification>> 15.8.4
 * 
 * Any lexically enclosing instance can be referred to by explicitly qualifying the keyword this.
 * 
 * Let C be the class denoted by ClassName. Let n be an integer such that C is the nth lexically enclosing class 
 * of the class in which the qualified this expression appears. The value of an expression of the form ClassName.this 
 * is the nth lexically enclosing instance of this (§8.1.3). The type of the expression is C. 
 * It is a compile-time error if the current class is not an inner class of class C or C itself.
 *
 * @author Quqing Liu
 */
public class QualifiedThis {
	class A {
		void helloA() {}
		class B {
			void helloB() {}
			class C {
				void helloC() {
					//Qualified this
					A.B.this.helloB();
					A.this.helloA();
					this.helloC();
				}
			}
		}
	}
}
