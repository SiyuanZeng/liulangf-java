/**
 * 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
 */
package com.liulangf.pattern.gof.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 * @author liulangf
 *
 */
public class HelloWorld {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
	
	interface A {
		void a();
	}
	
	interface B {
		void b();
	}
	
	public void hello() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = new Class<?>[]{ A.class, B.class};
		class Handler implements InvocationHandler {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) 
					throws Throwable {
				LOGGER.info("====[{}]", proxy.getClass().getName());
				return null;
			}
		}
		
		Object proxy = Proxy.newProxyInstance(loader, interfaces, new Handler());
		LOGGER.info("proxy is [{}]", proxy.getClass().getName());
		
		Class<?>[] is = proxy.getClass().getInterfaces();
		for (Class<?> c : is) {
			LOGGER.info("[{}]", c.getName());
		}
		
		LOGGER.info("A.class.isAssignableFrom({}) is [{}]", proxy.getClass().getName(), A.class.isAssignableFrom(proxy.getClass()));
		LOGGER.info("B.class.isAssignableFrom({}) is [{}]", proxy.getClass().getName(), B.class.isAssignableFrom(proxy.getClass()));
		
		A a = (A) proxy;
		B b = (B) proxy;
		
		a.a();
		b.b();
	}

	public static void main(String...args) {
		new HelloWorld().hello();
	}

}
