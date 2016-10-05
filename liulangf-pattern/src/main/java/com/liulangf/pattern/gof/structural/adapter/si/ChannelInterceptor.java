package com.liulangf.pattern.gof.structural.adapter.si;

/**
 * From Spring Integration.
 * 
 * @author liulangf
 *
 */
public interface ChannelInterceptor {
	
	void preSend(Object message);
	void postSend(Object message);
	
	boolean preReceive();
	Object postReceive();
	

}
