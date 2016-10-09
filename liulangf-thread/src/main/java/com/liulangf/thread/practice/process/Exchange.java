package com.liulangf.thread.practice.process;

/**
 *
 * @author Quqing Liu
 */
public interface Exchange {

	String getExchangeId();
	
	boolean isTransacted();
	
	void setException(Throwable e);
	
	UnitOfWork getUnitOfWork();
}
