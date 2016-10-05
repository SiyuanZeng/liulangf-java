/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Quqing Liu
 */
public class DebugProxy implements InvocationHandler {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(DebugProxy.class);
	private Object obj;

    public static Object newInstance(Object obj) {
	    return java.lang.reflect.Proxy.newProxyInstance(
	        obj.getClass().getClassLoader(),
	        obj.getClass().getInterfaces(),
	        new DebugProxy(obj));
    }

    private DebugProxy(Object obj) {
	    this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args) 
            throws Throwable {
        Object result;
		try {
			LOGGER.info("before method {},", m.getName());
		    result = m.invoke(obj, args);
	        } catch (InvocationTargetException e) {
		    throw e.getTargetException();
	        } catch (Exception e) {
		    throw new RuntimeException("unexpected invocation exception: " +
					       e.getMessage());
		} finally {
			LOGGER.info("after method {},", m.getName());
		}
		return result;
    }
    
    public static void main(String...args) {
    	Target target = (Target)newInstance(new Target() {
    		public String apply(String from) {
    			return "Hello " + from;
    		}
    	});
    	target.apply("Liu Yuqing");
    }
}
