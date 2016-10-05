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
 * java.lang.reflect.Proxy class and the 
 * java.lang.reflect.InvocationHandler interface, 
 * which make up the heart of Dynamic Proxy's functionality.
 * 
 * Every proxy has an associated invocation handler that is called whenever one of the proxy's methods is called. 
 * In keeping with the general design principle that interfaces are for defining types and classes are for defining 
 * implementations, proxy objects can implement one or more interfaces, but not classes. 
 * Because proxy classes do not have accessible names, they cannot have constructors, 
 * so they must instead be created by factories.
 *
 * @author Quqing Liu
 */
public class DynamicProxyInJava {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(DynamicProxyInJava.class);
	
	/**
	 * A proxy forces object method calls to occur indirectly through the proxy object, 
	 * which acts as a surrogate or delegate for the underlying object being proxied. 
	 * Proxy objects are usually declared so that the client objects have no indication 
	 * that they have a proxy object instance.
	 * 
	 * The proxy is a fundamental design pattern that is used quite often in programming. 
	 * However, one of its drawbacks is the specificity or tight coupling of the proxy 
	 * with its underlying object. 
	 */
	public void proxy() {
	}
	
	/**
	 * At the heart of the dynamic proxy mechanism is the InvocationHandler interface, 
	 * The job of an invocation handler is to actually perform the requested method invocation 
	 * on behalf of a dynamic proxy. The ingvocation handler is passed a Method object 
	 * (from the java.lang.reflect package) and the list of arguments to be passed to the method; 
	 * in the simplest case, it could simply call the reflective method Method.invoke() and return the result.
	 */
	public void handler() {
	}
	
	public static void main(String...args) {
		
		final Target subject = new ConcretTarget();
		InvocationHandler handler = new InvocationHandler() {
			
			/**
			 * @param proxy the proxy instance that the method was invoked on
			 * @param method the <code>Method</code> instance corresponding to
             *               the interface method invoked on the proxy instance. 
			 * @param args   the args to the method instance
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				LOGGER.info("Before...");
				LOGGER.info("{}", proxy.getClass().getInterfaces());
				
				if (proxy instanceof Target) {
				    Target pt = (Target) proxy;
				    //死循环了
				    //pt.apply("aaaaaaaaaaaaaaaaaa");
				}
				
				//Object original =  method.invoke(subject, args);
				String original = subject.apply(args[0].toString());
				LOGGER.info("{}", original);
				LOGGER.info("After...");
				return original;
			}
		};
		
		Target target = (Target)Proxy.newProxyInstance(
				subject.getClass().getClassLoader(), 
				subject.getClass().getInterfaces(), //must be interface
				handler);
		
		target.apply("LiuYuQing");
		
		GenericProxyFactory.newProxy(target, handler).apply("LiuYuQing");
		GenericProxyFactory.newProxy(target, Target.class, handler).apply("LiuYuQing");
		
		GenericProxyFactory.newProxy(
				target, 
				new ProxyBuilder<Target>(subject) {
					public Object invoke(Target target, Object[] args) {
						return target.apply(args[0].toString());
					}
				}
		).apply("LiuYuQing");
		
		//So cool, my handler
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
