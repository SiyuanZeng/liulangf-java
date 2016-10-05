package com.liulangf.pattern.eda.simple;

import java.util.EventObject;

public class TickEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public TickEvent(Object source) {
		super(source);
	}
}
