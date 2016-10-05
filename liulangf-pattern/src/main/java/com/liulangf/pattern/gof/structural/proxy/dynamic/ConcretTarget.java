/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

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
