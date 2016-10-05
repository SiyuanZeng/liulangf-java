package com.liulangf.java8.dynamic;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodHandleTest {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() throws Throwable {
		File file = new File("a.txt");
		
		MethodHandle getName = MethodHandles.lookup().findVirtual(
				file.getClass(), 
				"getName", 
				MethodType.methodType(String.class));
		
		String name = (String) getName.invokeExact(file);
		log.info("{}", name);
	}

}
