/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.generic.camel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * getThisTrick() === (T)this;//type cast
 * 
 * @author YuQing Liu
 */
public abstract class SelfReferentialType<T extends SelfReferentialType<T>> {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(SelfReferentialType.class);
	
	private SomeOtherType<T> ref; 
	
	public SelfReferentialType(SomeOtherType<T> ref) {
		this.ref = ref;
	}
	
	/**
	 * getThisTrick() and (T)this;
	 */
	@SuppressWarnings("unchecked")
	public void aMethod() {
		// error: incompatible types
		//ref.m(this);
		
		ref.m((T) this);
	}
	
	public static void main(String...args) {
		LOGGER.info("getThisTrick() and (T) this;");
		Hello hello = new Hello(new SomeOtherType<Hello>() {
			public void m(Hello arg) {
				LOGGER.info("{}", arg.getClass());
			}
		});
		
		hello.aMethod();
	}
	
}

class Hello extends SelfReferentialType<Hello> {
	public Hello(SomeOtherType<Hello> ref) {
		super(ref);
	}
}

