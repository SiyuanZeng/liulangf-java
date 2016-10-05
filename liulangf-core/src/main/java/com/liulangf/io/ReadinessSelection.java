/*
 * 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
 */
package com.liulangf.io;

/**
 * From  chapter 12.5 of <<Java Network Programming, 3rd>>.
 * 
 * For network programming, the second part of the new I/O APIs is readiness selection, 
 * the ability to choose a socket that will not block when read or written. 
 * This is primarily of interest to servers, although clients running multiple simultaneous 
 * connections with several windows open—such as a web spider or a browser—can take advantage of it as well.
 * 
 * In order to perform readiness selection, different channels are registered with a Selector object. 
 * Each channel is assigned a SelectionKey. The program can then ask the Selector object for the set of 
 * keys to the channels that are ready to perform the operation you want to perform without blocking.
 * 
 * @author YuQing Liu
 *
 */
public interface ReadinessSelection {
	
	
}
