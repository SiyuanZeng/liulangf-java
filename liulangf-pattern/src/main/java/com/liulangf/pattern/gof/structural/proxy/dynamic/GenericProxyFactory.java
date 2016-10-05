
package com.liulangf.pattern.gof.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author Quqing Liu
 */
public class GenericProxyFactory {
	
	@SuppressWarnings("unchecked")
	public static <T> T newProxy(final T target, Class<T> iface, InvocationHandler handler) {
		Object proxy = Proxy.newProxyInstance(iface.getClassLoader(), new Class[] {iface}, handler);
		//Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[] {iface}, handler);
		return (T)proxy;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T newProxy(final T target, InvocationHandler handler) {
		Class<?> clazz = target.getClass();
		Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
		return (T)proxy;
	}

}
