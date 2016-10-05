/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * So cool.
 * 
 * @author Quqing Liu
 */
public abstract class ProxyBuilder<T> implements InvocationHandler {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(ProxyBuilder.class);
	private T target;
	
	public ProxyBuilder(T target) {
		this.target = target;
	}
	
	/**
	 * @param proxy   almost you won't use this instance
	 * @param method  almost you won't use this instance, use the target instance instead
	 * @param args
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return invoke(target, args);
	}
	
	/**
	 * Callback method, will be invoked by the dynamic proxy finally.
	 * 
	 * @param target
	 * @param args
	 * @return
	 */
	public abstract Object invoke(T target, Object[] args);
	
	@SuppressWarnings("unchecked")
	public T build() {
		Class<?> clazz = target.getClass();
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	
	public static void main(String... args) {
		new ProxyBuilder<Target>(new Target() {
			public String apply(String from) {
				return "This is so cool. You are welcome , " + from;
			}
		}) {
			public Object invoke(Target target, Object[] args) {
				LOGGER.info("=================Before=============");
				String original = target.apply(args[0].toString());
				LOGGER.info("{}", original);
				LOGGER.info("=================After==============");
				return original;
			}
		}.build().apply("liuyuqing");
	}
	
}
