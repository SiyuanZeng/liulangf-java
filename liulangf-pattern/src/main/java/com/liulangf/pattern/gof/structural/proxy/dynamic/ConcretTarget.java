package com.liulangf.pattern.gof.structural.proxy.dynamic;

/**
 *
 * @author Quqing Liu
 */
public class ConcretTarget implements Target {

	@Override
	public String apply(String src) {
		return "Hello [ " + src + " ]";
	}
}
