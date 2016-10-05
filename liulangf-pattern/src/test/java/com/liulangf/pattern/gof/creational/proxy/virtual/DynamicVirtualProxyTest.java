package com.liulangf.pattern.gof.creational.proxy.virtual;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liulangf.pattern.gof.structural.proxy.virtual.RealSubject;
import com.liulangf.pattern.gof.structural.proxy.virtual.Subject;

public class DynamicVirtualProxyTest {
	
	private Subject proxy;
	private ExecutorService executor;
	
	@Before
	public void setUp() {
		executor = Executors.newFixedThreadPool(1);
		proxy = newProxy(new RealSubject());
	}
	
	private Subject newProxy(Subject target) {
		Class<?> clazz = target.getClass();
		return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler(target));
	}
	
	private InvocationHandler handler(Subject target) {
		return new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
				Future<Long> future = executor.submit(() -> {
					return (Long) method.invoke(target, args);
				});
				
				int secs = 0;
				
				while (!future.isDone()) {
					try {
						TimeUnit.SECONDS.sleep(1);
						System.out.print(" " + ++secs);
					} catch (InterruptedException e) {
					}
				}
				
				System.out.println("");
				
				try {
					return future.get();
				} catch (InterruptedException e) {
				} catch (ExecutionException e) {
				}
				return -1L;
			}
		};
	}
	
	@After
	public void tearDown() {
		executor.shutdown();
	}

	@Test
	public void test() {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratatedFiles", true);
		System.out.println("Begin");
		System.out.println("The result is " + proxy.execute());
		System.out.println("Over!");
	}

}
