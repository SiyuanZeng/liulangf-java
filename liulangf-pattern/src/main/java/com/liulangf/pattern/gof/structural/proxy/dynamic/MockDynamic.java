package com.liulangf.pattern.gof.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @
 *
 * @author Quqing Liu
 */
public class MockDynamic {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(MockDynamic.class);
	
    /**
     * Creates a mock object of type <var>typeToMock</var> with the given name.
     */
	@SuppressWarnings("unchecked")
    public <T> T mock(Class<T> typeToMock, String name) {
		ClassLoader cd = typeToMock.getClassLoader();
		Class<?>[] interfaces = new Class<?>[]{typeToMock};
        return (T)Proxy.newProxyInstance(cd , interfaces, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            	LOGGER.info("I am a proxy. ");
            	return null;
            }
        });
    }

	public static void main(String...args) {
		MaliMaliHong mali = new MockDynamic().mock(MaliMaliHong.class, "malimalihong");
		mali.didadi();
		
	}
}

interface MaliMaliHong {
	int didadi();
}

