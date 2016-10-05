/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.generic.faq.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * How do I recover the element type of a container?
 * By having the container carry the element type as a type token.
 * 
 * @author LiuYuqing
 */
public class WildcardCaptureTrick {
}

interface Contained{}

interface Container<T extends Contained> {
	void add(T element);
	List<T> elements();
	Class<T> getElementType();
}

class MyContained implements Contained {
	private final String name;
	public MyContained(String name) {
		this.name = name;
	}
	public @Override String toString() {
		return name;
	}
}

class MyContainer implements Container<MyContained> {
	private final List<MyContained> elements = new ArrayList<MyContained>();
	public void add(MyContained element) {
		elements.add(element);
	}
	public List<MyContained> elements() {
		return elements;
	}
	public Class<MyContained> getElementType() {
		return MyContained.class;
	}
}

class MetaContainer {
	private Container<? extends Contained> container;
	public void setContainer(Container<? extends Contained> container) {
		this.container = container;
	}
	public void add(Contained element) {
		//
		//container.add(container.getElementType().cast(element));
		add(container, element);
	}
	
	/**
	 * Wildcard capture:
	 * This programming technique relies on the fact that the compiler performs type argument inference 
	 * when a generic method is invoked. It means that the type of the container argument in the helper method add()
	 * is not a wildcard parameterization, but a concrete parameterization for an unknown type that the compiler 
	 * infers when the method is invoked. The key point is that the container is no longer of a wildcard type and 
	 * we may eventually invoke its add() method.
	 * 
	 * @param <T>
	 * @param container
	 * @param element
	 */
	private static <T extends Contained> void add(Container<T> container, Contained element) {
		container.add(container.getElementType().cast(element));
	}
	public List<? extends Contained> elements() {
		return container.elements();
	}
}
