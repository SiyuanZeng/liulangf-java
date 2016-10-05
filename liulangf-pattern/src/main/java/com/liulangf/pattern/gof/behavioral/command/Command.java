/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.behavioral.command;

/**
 * Command pattern 的主旨及方法的invocation 和 execution 分离。
 * 
 * Command pattern 对于设计框架中的callback 非常有用。
 *
 * @author Quqing Liu
 */
public interface Command {

	void execute();
}
