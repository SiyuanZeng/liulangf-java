/*
 * 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
 */
package com.liulangf.thread.practice.process;

/**
 * @author YuQing Liu
 *
 */
public interface UnitOfWork {
	
	AsyncCallback beforeProcess(AsyncProcessor p, Exchange e, AsyncCallback c);
	AsyncCallback afterProcess(AsyncProcessor p, Exchange e, AsyncCallback c, boolean sync);
}
