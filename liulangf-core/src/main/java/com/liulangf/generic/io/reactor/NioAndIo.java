/*
 * 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
 */
package com.liulangf.io.reactor;

/**
 * @author YuQing Liu
 *
 */
public class NioAndIo {
	
	/**
	 * <ul>
	 *   <li>Asynchronous IO is faster</li>
	 *   <li>Thread context switching is slow</li>
	 *   <li>Threads take up too much memory</li>
	 *   <li>Synchronization among threads will kill you</li>
	 *   <li>Thread-per-connection does not scale</li>
	 * </ul>
	 */
	void chooseNio() {}
	
}
