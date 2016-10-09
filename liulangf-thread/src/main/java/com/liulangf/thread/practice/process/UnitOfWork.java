package com.liulangf.thread.practice.process;

/**
 * @author YuQing Liu
 *
 */
public interface UnitOfWork {
	
	AsyncCallback beforeProcess(AsyncProcessor p, Exchange e, AsyncCallback c);
	AsyncCallback afterProcess(AsyncProcessor p, Exchange e, AsyncCallback c, boolean sync);
}
