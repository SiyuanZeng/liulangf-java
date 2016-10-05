package com.liulangf.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;

public class TestClass {

	private final Class<?> fClass;

	private Map<Class<?>, List<FrameworkMethod>> fMethodsForAnnotations = 
			new HashMap<Class<?>, List<FrameworkMethod>>();

	private Map<Class<?>, List<FrameworkField>> fFieldsForAnnotations = 
			new HashMap<Class<?>, List<FrameworkField>>();

	public TestClass(Class<?> kClass) {
		this.fClass = kClass;
	}
}
